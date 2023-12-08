package com.kob.backend.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kob.backend.consumer.utils.JwtAuthentication;
import com.kob.backend.consumer.utils.MessageTypeEnum;
import com.kob.backend.dataobject.UserDO;
import com.kob.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
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
     *
     * @param session 会话
     * @param token   用户 jwt 令牌
     * @throws IOException 异常
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
     * 关闭连接
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
     * 从 Client 接收请求
     *
     * @param message 请求信息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        JSONObject data = JSON.parseObject(message);
        Integer type = Integer.parseInt(data.getString("type"));
        MessageTypeEnum messageType = MessageTypeEnum.getEnumByValue(type);

        String msgData = data.getString("msgData");
        log.info("message:{}", message);
        switch (messageType) {
            case GROUP_MESSAGE:
                Integer userId = Integer.parseInt(data.getString("userId"));
                Integer groupId = Integer.parseInt(data.getString("groupId"));
                sendBoardCastMessage(userId, groupId, msgData);
                break;
            case FRIEND_MESSAGE:
                sendMessage(msgData);
                break;
            case GAME_MESSAGE:

                break;
            case FRIEND_REQUEST:
                Integer friendId = Integer.parseInt(data.getString("userId"));
                sendFriendRequestMessage(msgData, users.get(friendId).session);
                break;
            case SYSTEM_WARNING:
                sendAllMessage(message);
                break;
            default:
                break;
        }
    }

    /**
     * 向所有用户推送系统通知
     *
     * @param message 通知信息
     */
    private void sendAllMessage(String message) {
        // 遍历 map，拿到每一个用户的 session
        List<Session> sessions = new ArrayList<>();
        users.forEach((k, v) -> sessions.add(v.session));
        // 向每个用户推送消息
        sessions.forEach(s -> {
            synchronized (s) {
                try {
                    s.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    /**
     * 向聊天组发送信息
     *
     * @param userId  当前用户 id
     * @param groupId 群组 id
     * @param msg     发送的消息内容
     */
    private void sendBoardCastMessage(Integer userId, Integer groupId, String msg) {

    }

    /**
     * 给 Client 发送消息
     *
     * @param message 消息内容
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

    /**
     * 给 Client 发送好友申请消息
     *
     * @param message   好友申请消息内容
     * @param toSession 目标好友 session
     */
    public void sendFriendRequestMessage(String message, Session toSession) {
        synchronized (toSession) {
            try {
                // 直接把好友申请消息发送给目标好友
                toSession.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
