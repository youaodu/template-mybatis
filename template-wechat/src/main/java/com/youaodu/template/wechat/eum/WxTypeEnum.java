package com.youaodu.template.wechat.eum;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;

@Getter
public enum WxTypeEnum {
    IMAGE("图片", "image"),
    VOICE("语音", "voice"),
    VIDEO("视频", "video"),
    THUMB("缩略图", "thumb"),
    UNSUBSCRIBE("取消关注", "unsubscribe"),
    SUBSCRIBE("关注", "unsubscribe"),
    TEXT("文本", "text")
    ;

    WxTypeEnum(String type, String code) {
        this.type = type;
        this.code = code;
    }

    public static WxTypeEnum query(String type) {
        for (WxTypeEnum item : WxTypeEnum.values()) {
            if (StrUtil.equalsIgnoreCase(type, item.getCode())) {
                return item;
            }
        }
        return null;
    }

    private String type;

    private String code;
}
