package com.kob.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kob.backend.dataobject.FriendDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 好友表(Friend)表服务接口
 *
 * @author makejava
 * @since 2023-09-11 22:16:15
 */
public interface FriendService extends IService<FriendDO> {

}
