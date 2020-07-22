package com.youaodu.template.common.entity.pojo.dto.client;

import lombok.Data;

@Data
public class UserInfoDto {

    private String openId; // 微信唯一ID

    private String code; // 微信code
}
