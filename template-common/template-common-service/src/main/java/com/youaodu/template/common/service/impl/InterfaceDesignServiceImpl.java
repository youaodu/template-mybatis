package com.youaodu.template.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youaodu.template.common.dao.mapper.InterfaceDesignMapper;
import com.youaodu.template.common.entity.model.InterfaceDesign;
import com.youaodu.template.common.service.InterfaceDesignService;
import org.springframework.stereotype.Service;

@Service
public class InterfaceDesignServiceImpl extends ServiceImpl<InterfaceDesignMapper, InterfaceDesign> implements InterfaceDesignService {
}
