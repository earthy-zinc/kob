package com.kob.backend.biz.user;

import com.kob.backend.controller.user.vo.*;

public interface UserBiz {
    // 获取 token
    AccountRespVO getToken(AccountReqVO accountReqVO);

    // 注册
    String register(AccountReqVO accountReqVO);

    // 获取登录用户信息
    UserRespVO getUserInfo();

    // 更新用户信息
    void updateUserInfo(UserInfoReqVO userInfoReqVO);

    void updateUserWalletInfo(Wallet wallet);
}
