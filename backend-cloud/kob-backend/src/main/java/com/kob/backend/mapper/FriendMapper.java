package com.kob.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kob.backend.dataobject.FriendDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 好友表(Friend)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-11 22:16:12
 */
@Mapper
@Repository
public interface FriendMapper extends BaseMapper<FriendDO> {

}

