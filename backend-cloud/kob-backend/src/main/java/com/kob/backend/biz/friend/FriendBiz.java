package com.kob.backend.biz.friend;

import com.kob.backend.common.PageMap;
import com.kob.backend.controller.friend.vo.FriendReqVO;
import com.kob.backend.controller.friend.vo.FriendVO;

public interface FriendBiz {

    /**
     * 调用websocket接口向目标用户发送好友请求消息
     */
    void sendFriendVerification(Integer userId, Integer friendUserId);
    /**
     * 接受或拒绝好友请求
     */
    boolean handleFriendRequest(FriendReqVO friend);
    /**
     * 删除好友
     */
    void deleteFriend(Integer userId, Integer friendUserId);

    /**
     * 查询好友列表
     */
    PageMap<FriendVO> listFriend(Integer userId);
}
