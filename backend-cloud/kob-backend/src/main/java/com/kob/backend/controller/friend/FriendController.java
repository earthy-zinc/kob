package com.kob.backend.controller.friend;


import com.kob.backend.biz.friend.FriendBiz;
import com.kob.backend.biz.user.UserBiz;
import com.kob.backend.common.PageQuery;
import com.kob.backend.common.Result;
import com.kob.backend.controller.friend.vo.FriendReqVO;
import com.kob.backend.controller.user.vo.UserRespVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/friend")
public class FriendController {

    @Resource
    private FriendBiz friendBiz;

    @Resource
    private UserBiz userBiz;

    /**
     * 发起好友请求
     *
     * @param userId 要添加好友的 id
     * @return 响应结果
     */
    @GetMapping("/verification")
    public Result<?> sendFriendVerification(@RequestParam("id") Integer userId) {
        UserRespVO userInfo = userBiz.getUserInfo();
        friendBiz.sendFriendVerification(userInfo.getId(), userInfo.getUsername(), userId);
        return Result.success("发送好友申请成功！");
    }

    /**
     * 处理好友请求
     *
     * @return true 接受 / false 拒绝
     */
    @PostMapping
    public Result<?> handleFriendRequest(@RequestBody FriendReqVO friendReqVO) {
        return Result.success(friendBiz.handleFriendRequest(friendReqVO));
    }

    /**
     * 删除朋友
     *
     * @return 响应结果
     */
    @DeleteMapping
    public Result<?> deleteFriend(@RequestParam("id") Integer friendId) {
        UserRespVO userInfo = userBiz.getUserInfo();
        UserRespVO friendInfo = userBiz.getUserInfoById(friendId);
        friendBiz.deleteFriend(userInfo.getUsername(), friendInfo.getUsername());
        return Result.success("已删除该好友！");
    }

    /**
     * 获取朋友列表
     *
     * @return 响应结果
     */
    @GetMapping
    public Result<?> getFriendList(@RequestBody PageQuery pageQuery) {
        UserRespVO userInfo = userBiz.getUserInfo();
        return Result.success(friendBiz.listFriend(userInfo, pageQuery));
    }
}
