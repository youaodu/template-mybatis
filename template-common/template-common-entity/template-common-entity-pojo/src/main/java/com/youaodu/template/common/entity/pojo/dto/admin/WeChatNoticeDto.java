package com.youaodu.template.common.entity.pojo.dto.admin;

import lombok.Data;

@Data
public class WeChatNoticeDto {
    private String Content;

    private String CreateTime;

    private String ToUserName;

    private String FromUserName;

    private String MsgType;

    private String MsgId;

    private String EventKey;

    private String Event;
}
