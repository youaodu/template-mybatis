package com.youaodu.template.common.main.biz.impl;

import com.youaodu.template.common.entity.pojo.dto.main.RootDto;
import com.youaodu.template.common.main.biz.ApiBiz;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ApiBizImpl implements ApiBiz {

    /**
     * 根路径
     * @param rootDto
     * @return
     */
    @Override
    public Map<String, Object> root(RootDto rootDto) {

        return null;
    }
}
