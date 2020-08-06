package com.youaodu.template.admin.biz.impl;

import cn.hutool.json.JSONUtil;
import com.youaodu.template.admin.biz.WeChatBiz;
import com.youaodu.template.common.entity.pojo.dto.admin.WeChatNoticeDto;
import org.springframework.stereotype.Service;

@Service
public class WeChatBizImpl implements WeChatBiz {

    @Override
    public void noticeWeChat(WeChatNoticeDto weChatNoticeDto) {
        System.out.println(JSONUtil.toJsonStr(weChatNoticeDto));
    }
}
