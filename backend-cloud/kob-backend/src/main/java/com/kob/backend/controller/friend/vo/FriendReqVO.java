package com.kob.backend.controller.friend.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class FriendReqVO {
    @NotBlank(message = "发送方不能为空")
    private Integer userId;
    @NotBlank(message = "接受方不能为空")
    private Integer userFriendId;
    @NotBlank(message = "是否接受好友请求？应传布尔值")
    private Boolean isAccept;
}
