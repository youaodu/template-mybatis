package com.youaodu.template.client.biz;

import com.youaodu.template.common.entity.pojo.dto.client.UserInfoDto;
import com.youaodu.template.common.entity.pojo.vo.client.UserInfoVo;

public interface WechatBiz {
    UserInfoVo userInfo(UserInfoDto userInfoDto);
}
