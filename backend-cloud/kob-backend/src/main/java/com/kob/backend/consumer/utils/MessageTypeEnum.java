package com.kob.backend.consumer.utils;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;


@Getter
public enum MessageTypeEnum {

    GROUP_MESSAGE(1, "群聊消息"),
    FRIEND_MESSAGE(2, "好友消息"),
    GAME_MESSAGE(3, "对战消息"),
    FRIEND_REQUEST(4, "好友请求"),
    SYSTEM_WARNING(5, "系统警告");

    private final Integer value;
    private final String label;
    MessageTypeEnum(Integer value, String label){
        this.value = value;
        this.label = label;
    }

    public static MessageTypeEnum getEnumByValue(Integer value) {
        MessageTypeEnum[] messageTypeEnums = MessageTypeEnum.values();
        return Arrays.stream(messageTypeEnums)
                .filter(messageTypeEnum -> Objects.equals(messageTypeEnum.value, value))
                .findFirst()
                .orElse(null);
    }

}
