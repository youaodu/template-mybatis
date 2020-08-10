package com.youaodu.template.wechat.bo;

import lombok.Data;

@Data
public class SendMsgBo {

    /**
     * 用户OpenId
     */
    private String toUserOpenId;

    /**
     * 消息类型
     */
    private String msgType;

    /**
     * 消息体
     */
    private String content;

    /**
     * 媒体Id
     */
    private String mediaId;

    /**
     * news标题
     */
    private String title;

    /**
     * news描述
     */
    private String description;

    /**
     * news跳转地址
     */
    private String url;

    /**
     * news图片
     */
    private String picurl;
}

