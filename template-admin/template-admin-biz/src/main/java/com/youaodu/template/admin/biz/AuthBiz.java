package com.youaodu.template.admin.biz;

import com.youaodu.template.common.entity.pojo.vo.admin.TreeVo;
import com.youaodu.template.common.framework.token.Token;

import java.util.List;

public interface AuthBiz {
    List<TreeVo> tree(Token token);
}
