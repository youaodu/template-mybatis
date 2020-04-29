package com.youaodu.template.admin.biz;

import com.youaodu.template.common.entity.pojo.dto.admin.LoginDto;
import com.youaodu.template.common.entity.pojo.vo.admin.LoginVo;

public interface AccountBiz {
    LoginVo login(LoginDto loginDto);
}
