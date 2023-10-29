package com.kob.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kob.backend.dataobject.FriendDO;
import com.kob.backend.mapper.FriendMapper;
import com.kob.backend.service.FriendService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 好友表(Friend)表服务实现类
 *
 * @author makejava
 * @since 2023-09-11 22:16:16
 */
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, FriendDO> implements FriendService {

}
