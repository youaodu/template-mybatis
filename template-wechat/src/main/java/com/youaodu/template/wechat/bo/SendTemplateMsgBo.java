package com.youaodu.template.wechat.bo;

import lombok.Data;

import java.util.Map;

@Data
public class SendTemplateMsgBo {

    /**
     * 用户openId
     */
    private String openId;

    /**
     * 模板ID
     */
    private String templateId;

    /**
     * 跳转的URL
     */
    private String url;

    /**
     * 跳转小程序的APPId
     */
    private String miniAppId;

    /**
     * 跳转小程序的页面地址
     */
    private String miniPagePath;

    /**
     * 消息中的参数
     */
    private Map<String, Object> params;



}
