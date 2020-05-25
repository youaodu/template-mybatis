package com.youaodu.template.wechat.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class WeChatConfig {

    @Value("${wechat.appSecret}")
    private String appSecret;

    @Value("${wechat.appId}")
    private String appId;
}
