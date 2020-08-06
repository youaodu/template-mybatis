package com.youaodu.template.admin.biz.impl.wxHandler;

import com.youaodu.template.common.entity.pojo.dto.admin.WeChatNoticeDto;

public interface WxHandlerIfac {

    String getKey();

    void exec(WeChatNoticeDto weChatNoticeDto);
}
