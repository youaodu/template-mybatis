package com.youaodu.template.wechat.bo;

import lombok.Data;

@Data
public class ScriptAuthBoVo {

    private String appId;

    private Long timestamp;

    private String nonceStr;

    private String signature;
}
