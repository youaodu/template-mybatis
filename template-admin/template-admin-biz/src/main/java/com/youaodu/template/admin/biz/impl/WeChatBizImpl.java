package com.youaodu.template.admin.biz.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.youaodu.template.admin.biz.WeChatBiz;
import com.youaodu.template.admin.biz.impl.wxHandler.WxHandlerFactory;
import com.youaodu.template.admin.biz.impl.wxHandler.WxHandlerIfac;
import com.youaodu.template.common.entity.pojo.dto.admin.WeChatNoticeDto;
import org.springframework.stereotype.Service;

@Service
public class WeChatBizImpl implements WeChatBiz {

    @Override
    public void noticeWeChat(WeChatNoticeDto weChatNoticeDto) {
        WxHandlerIfac ifac;
        if (StrUtil.equalsIgnoreCase("event", weChatNoticeDto.getMsgType())) {
            ifac = WxHandlerFactory.getInstance().get(weChatNoticeDto.getEvent());
        } else {
            ifac = WxHandlerFactory.getInstance().get(weChatNoticeDto.getMsgType());
        }

        if (ifac != null) {
            ifac.exec(weChatNoticeDto);
        }
    }
}
