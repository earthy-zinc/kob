package com.kob.backend.controller.user.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Wallet {
    private String mnemonic;
    private String address;
}
