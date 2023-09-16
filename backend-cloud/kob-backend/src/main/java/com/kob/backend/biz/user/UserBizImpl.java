package com.kob.backend.biz.user;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kob.backend.controller.user.vo.*;
import com.kob.backend.convert.UserConverter;
import com.kob.backend.dataobject.UserDO;
import com.kob.backend.exception.BusinessException;
import com.kob.backend.exception.ErrorCodeEnum;
import com.kob.backend.security.UserDetailsImpl;
import com.kob.backend.service.UserService;
import com.kob.backend.utils.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserBizImpl implements UserBiz {
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private UserService userService;
    @Resource
    private PasswordEncoder passwordEncoder;

    //登录
    @Override
    public AccountRespVO getToken(AccountReqVO accountReqVO) throws BusinessException {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(accountReqVO.getUsername(), accountReqVO.getPassword());

        Authentication authenticate;
        // 登录失败，抛出自定义异常
        try {
            authenticate = authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            throw new BusinessException(ErrorCodeEnum.LOGIN_PASSWORD_INVALID_EXCEPTION);
        }
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();
        UserDO user = loginUser.getUser();
        String jwt = JwtUtil.createJWT(user.getId().toString());

        return new AccountRespVO().setToken(jwt);
    }

    //注册
    @Override
    public String register(AccountReqVO accountReqVO) {
        String username = accountReqVO.getUsername(), password = accountReqVO.getPassword(),
                reenteredPassword = accountReqVO.getReenteredPassword();
        if (!password.equals(reenteredPassword)) {
            return "两次输入的密码不一致";
        }
        List<UserDO> list = userService.list(Wrappers.<UserDO>lambdaQuery().eq(UserDO::getUsername, username));
        if (!list.isEmpty()) {
            return "用户已存在";
        }
        String encodedPassword = passwordEncoder.encode(password);
        UserDO user = new UserDO().setUsername(username).setName("匿名用户").setPassword(encodedPassword)
                .setRating(1500).setCreateTime(new Date());//
        userService.save(user);

        return null;
    }

    //用户详情
    @Override
    public UserRespVO getUserInfo() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        UserDO user = loginUser.getUser();
        //vo
        UserRespVO userRespVO = UserConverter.INSTANCE.do2vo(user);
        userRespVO.setAddress(user.getAddress());//同时返回address值
        return userRespVO;
    }

    //更新用户信息
    @Override
    public void updateUserInfo(UserInfoReqVO userInfoReqVO) {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        UserDO user = loginUser.getUser();

        userInfoReqVO.setId(user.getId());
        userService.updateById(UserConverter.INSTANCE.vo2do(userInfoReqVO));
    }

    //绑定钱包后 将钱包地址和用户助记词存入数据库
    @Override
    public void updateUserWalletInfo(Wallet wallet) {
        //获取用户id
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        UserDO u = loginUser.getUser();
        Integer id = u.getId();
        //封装
        UserDO user = new UserDO();
        user.setId(id);
        user.setMnemonic(wallet.getMnemonic());
        user.setAddress(wallet.getAddress());
        System.out.println(user);
        userService.updateById(user);
    }
}
