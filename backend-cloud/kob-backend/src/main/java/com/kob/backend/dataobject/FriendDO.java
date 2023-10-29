package com.kob.backend.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 好友表(Friend)实体类
 *
 * @author makejava
 * @since 2023-09-11 22:16:13
 */
@Data
@Accessors(chain = true)
@TableName("friend")
public class FriendDO {
    /**
     * 数据库自增ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 用户ID
     */
    private String username;
    /**
     * 用户好友ID
     */
    private String userFriendName;
    /**
     * 好友昵称
     */
    private String friendNickname;
    /**
     * 好友头像
     */
    private String friendAvatar;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date updateTime;


}

