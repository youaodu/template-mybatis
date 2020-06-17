package com.youaodu.template.common.main.biz;

import com.youaodu.template.common.entity.pojo.dto.main.RootDto;

import java.util.Map;

public interface ApiBiz {
    Map<String, Object> root(RootDto rootDto);
}
