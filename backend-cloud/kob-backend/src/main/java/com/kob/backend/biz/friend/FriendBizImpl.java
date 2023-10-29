package com.kob.backend.biz.friend;

import com.kob.backend.common.PageMap;
import com.kob.backend.controller.friend.vo.FriendReqVO;
import com.kob.backend.controller.friend.vo.FriendVO;

import javax.annotation.Resource;

public class FriendBizImpl implements FriendBiz {

    @Resource

    @Override
    public void sendFriendVerification(Integer userId, Integer friendUserId) {

    }

    @Override
    public boolean handleFriendRequest(FriendReqVO friend) {
        if(!friend.getIsAccept()) return false;
        return true;
    }

    @Override
    public void deleteFriend(Integer userId, Integer friendUserId) {

    }

    @Override
    public PageMap<FriendVO> listFriend(Integer userId) {
        return null;
    }
}
