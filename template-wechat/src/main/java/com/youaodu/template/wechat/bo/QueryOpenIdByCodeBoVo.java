package com.youaodu.template.wechat.bo;

import lombok.Data;

@Data
public class QueryOpenIdByCodeBoVo {

    private String accessToken; // 授权用 accessToken

    private String openId; // 微信唯一ID

}
