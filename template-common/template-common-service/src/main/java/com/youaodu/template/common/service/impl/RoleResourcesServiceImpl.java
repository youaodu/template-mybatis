package com.youaodu.template.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youaodu.template.common.dao.mapper.RoleResourcesMapper;
import com.youaodu.template.common.entity.model.RoleResources;
import com.youaodu.template.common.service.RoleResourcesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleResourcesServiceImpl extends ServiceImpl<RoleResourcesMapper, RoleResources> implements RoleResourcesService {
}
