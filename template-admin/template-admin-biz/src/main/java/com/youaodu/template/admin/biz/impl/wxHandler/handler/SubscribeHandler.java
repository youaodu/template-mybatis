package com.youaodu.template.admin.biz.impl.wxHandler.handler;

import com.youaodu.template.admin.biz.impl.wxHandler.WxHandlerIfac;
import com.youaodu.template.common.entity.pojo.dto.admin.WeChatNoticeDto;
import com.youaodu.template.wechat.eum.WxTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class SubscribeHandler implements WxHandlerIfac {

    @Override
    public String getKey() {
        return WxTypeEnum.SUBSCRIBE.getCode();
    }

    @Override
    public void exec(WeChatNoticeDto weChatNoticeDto) {
        // {"CreateTime":"1596703068","EventKey":"","Event":"unsubscribe","ToUserName":"gh_dba765fee3fd","FromUserName":"oyMF31UalMhW_KZA094xkWlOJFYQ","MsgType":"event"}
    }
}
