package com.youaodu.template.admin.biz;

import com.youaodu.template.common.entity.pojo.vo.admin.AllResVo;
import com.youaodu.template.common.framework.token.Token;

import java.util.List;

public interface ResourceBiz {
    List<AllResVo> allRes(Token token);
}
