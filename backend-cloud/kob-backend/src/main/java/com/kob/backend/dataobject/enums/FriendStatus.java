package com.kob.backend.dataobject.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 好友申请状态枚举类
 */
@Getter
public enum FriendStatus {
    UN_HANDLE(0, "未处理"),
    ACCEPT(1, "接受"),
    REJECT(2, "拒绝")
    ;

    @EnumValue
    private final int value;
    @JsonValue
    private final String desc;

    FriendStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
