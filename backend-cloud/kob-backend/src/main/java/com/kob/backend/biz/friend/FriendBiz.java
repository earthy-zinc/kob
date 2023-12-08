package com.kob.backend.biz.friend;

import com.kob.backend.common.PageMap;
import com.kob.backend.common.PageQuery;
import com.kob.backend.controller.friend.vo.FriendReqVO;
import com.kob.backend.controller.friend.vo.FriendVO;
import com.kob.backend.controller.user.vo.UserRespVO;

public interface FriendBiz {

    /**
     * 调用websocket接口向目标用户发送好友请求消息
     */
    void sendFriendVerification(Integer userId, String username, Integer friendUserId);
    /**
     * 接受或拒绝好友请求
     */
    boolean handleFriendRequest(FriendReqVO friend);
    /**
     * 删除好友
     */
    void deleteFriend(String username, String friendUsername);

    /**
     * 查询好友列表
     */
    PageMap<FriendVO> listFriend(UserRespVO currentUser, PageQuery pageQuery);
}
