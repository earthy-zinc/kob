package com.kob.backend.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kob.backend.consumer.utils.JwtAuthentication;
import com.kob.backend.consumer.utils.MessageTypeEnum;
import com.kob.backend.dataobject.UserDO;
import com.kob.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/websocket/message/{token}")
public class WebSocketMessageServer {
    public final static ConcurrentHashMap<Integer, WebSocketMessageServer> users = new ConcurrentHashMap<>();

    public static UserService userService;

    private Session session;

    private UserDO user;

    @Autowired
    public void setUserService(UserService userService) {
        WebSocketMessageServer.userService = userService;
    }

    /**
     * 建立连接
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) throws IOException {
        this.session = session;
        // 根据 token 获取用户 id
        int userId = JwtAuthentication.getUserId(token);
        this.user = userService.getById(userId);

        if (!Objects.isNull(this.user)) {
            users.put(userId, this);
        } else {
            this.session.close();
        }
    }

    /**
     * 关闭链接
     */
    @OnClose
    public void onClose() {
        if (!Objects.isNull(user)) {
            users.remove(user.getId());
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 从 Client 接收消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        JSONObject data = JSON.parseObject(message);
        Integer type = Integer.parseInt(data.getString("type"));
        MessageTypeEnum messageType = MessageTypeEnum.getEnumByValue(type);

        String msgData = data.getString("msgData");
        switch (messageType){
            case GROUP_MESSAGE :
                Integer userId = Integer.parseInt(data.getString("userId"));
                Integer groupId = Integer.parseInt(data.getString("groupId"));
                sendBoardCastMessage(userId, groupId, msgData);
                break;
            case FRIEND_MESSAGE :
                sendMessage(msgData);
                break;
            case GAME_MESSAGE:

                break;
            case FRIEND_REQUEST:
                break;
            case SYSTEM_WARNING:
                break;
            default:
                break;
        }
    }

    private void sendBoardCastMessage(Integer userId, Integer groupId, String msg) {

    }

    /**
     * 给 Client 发送消息
     */
    public void sendMessage(String message) {
        synchronized (session) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
