package com.youaodu.template.admin.biz.impl.wxHandler.handler;

import com.youaodu.template.admin.biz.impl.wxHandler.WxHandlerIfac;
import com.youaodu.template.common.entity.pojo.dto.admin.WeChatNoticeDto;
import com.youaodu.template.wechat.eum.WxTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class TextHandler implements WxHandlerIfac {

    @Override
    public String getKey() {
        return WxTypeEnum.TEXT.getCode();
    }

    @Override
    public void exec(WeChatNoticeDto weChatNoticeDto) {
        // {"Content":"is","CreateTime":"1596701838","ToUserName":"gh_dba765fee3fd","FromUserName":"oyMF31UalMhW_KZA094xkWlOJFYQ","MsgType":"text","MsgId":"22859273767163858"}
    }
}
