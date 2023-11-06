package com.kob.backend.biz.friend;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kob.backend.dataobject.enums.FriendStatus;
import com.kob.backend.common.PageMap;
import com.kob.backend.common.PageQuery;
import com.kob.backend.controller.friend.vo.FriendReqVO;
import com.kob.backend.controller.friend.vo.FriendVO;
import com.kob.backend.controller.user.vo.UserRespVO;
import com.kob.backend.dataobject.FriendDO;
import com.kob.backend.dataobject.UserDO;
import com.kob.backend.service.FriendService;
import com.kob.backend.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendBizImpl implements FriendBiz {

    @Resource
    private FriendService friendService;

    @Resource
    private UserService userService;

    /**
     * 调用websocket接口向目标用户发送好友请求消息
     *
     * @param userId       当前登录用户 id
     * @param username     当前登录用户名
     * @param friendUserId 要添加好友的 id
     */
    @Override
    public void sendFriendVerification(Integer userId, String username, Integer friendUserId) {
        // 得到要添加好友的信息
        UserDO friendUserInfo = userService.getById(friendUserId);
        FriendDO friendDO = FriendDO.builder()
                .username(username)
                .userFriendName(friendUserInfo.getUsername())
                .friendNickname(friendUserInfo.getName())
                .friendAvatar(friendUserInfo.getAvatar())
                .createTime(new Date())
                .updateTime(new Date())
                .build();
        // 向 friend 表中插入一条记录
        friendService.save(friendDO);
    }

    /**
     * 处理好友请求
     *
     * @param friend 请求好友信息
     * @return 接受 true / 拒绝 false
     */
    @Override
    public boolean handleFriendRequest(FriendReqVO friend) {
        /*
          查询朋友的用户信息，因为要处理好友请求，那一定是别人加了自己才能处理
          而在朋友加自己的请求中，已经向 friend 表中插入了数据了
          并且插入数据中的 username 为朋友的 username，
          friendUsername 为自己的 username
         */
        // 构造查询条件
        LambdaQueryWrapper<FriendDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(FriendDO::getUsername, friend.getUserFriendName())
                .eq(FriendDO::getUserFriendName, friend.getUsername());
        FriendDO friendDO = friendService.getOne(queryWrapper);
        // 接受好友申请，将 friend 表中的 is_accepted 字段置为 true
        if (friend.getIsAccept()) {
            // 将 is_accepted 字段置为 1，表示接受好友申请
            friendDO.setIsAccepted(FriendStatus.ACCEPT);
            // 修改 friend 表中的信息
            friendService.updateById(friendDO);
            return true;
        } else {
            // 将 is_accepted 字段置为 2，表示拒绝好友申请
            friendDO.setIsAccepted(FriendStatus.REJECT);
            // 修改 friend 表中的信息
            friendService.updateById(friendDO);
            return false;
        }
    }

    /**
     * 删除好友
     *
     * @param username       当前用户名
     * @param friendUsername 好友用户名
     */
    @Override
    public void deleteFriend(String username, String friendUsername) {
        LambdaQueryWrapper<FriendDO> queryWrapper = new LambdaQueryWrapper<>();
        // delete from friend where (username = 'admin' and user_friend_name = 'nn' and is_accepted = 1) or (username = 'nn' and user_friend_name = 'admin' and is_accepted = 1);
        queryWrapper.eq(FriendDO::getUsername, username)
                .eq(FriendDO::getUserFriendName, friendUsername)
                .eq(FriendDO::getIsAccepted, FriendStatus.ACCEPT)
                .or()
                .eq(FriendDO::getUsername, friendUsername)
                .eq(FriendDO::getUserFriendName, username)
                .eq(FriendDO::getIsAccepted, FriendStatus.ACCEPT);
        friendService.remove(queryWrapper);
    }

    /**
     * 获取朋友列表
     *
     * @param currentUser 登录用户信息
     * @param pageQuery   分页参数
     * @return 好友列表
     */
    @Override
    public PageMap<FriendVO> listFriend(UserRespVO currentUser, PageQuery pageQuery) {
        // 构造查询条件
        LambdaQueryWrapper<FriendDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(FriendDO::getUsername, currentUser.getUsername())
                .eq(FriendDO::getIsAccepted, FriendStatus.ACCEPT)
                .or()
                .eq(FriendDO::getUserFriendName, currentUser.getUsername())
                .eq(FriendDO::getIsAccepted, FriendStatus.ACCEPT);

        IPage<FriendDO> page = new Page<>(pageQuery.getPage(), pageQuery.getPageSize());
        page = friendService.page(page, queryWrapper);

        List<FriendDO> records = page.getRecords();
        if (CollUtil.isEmpty(records)) {
            return PageMap.empty();
        }
        // 将 List<FriendDO> 转换为 List<FriendVO>
        return PageMap.data(
                page.getTotal(),
                records.stream()
                        .map(friendDO -> FriendVO.builder()
                                .id(friendDO.getId())
                                .username(friendDO.getUserFriendName())
                                .name(friendDO.getFriendNickname())
                                .avatar(friendDO.getFriendAvatar())
                                .rating(String.valueOf(userService.getOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getUsername, friendDO.getUserFriendName())).getRating()))
                                .createTime(new Date())
                                .build()
                        )
                        .collect(Collectors.toList())
        );
    }
}
