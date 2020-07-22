package com.youaodu.template.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youaodu.template.common.dao.mapper.PagePointMapper;
import com.youaodu.template.common.entity.model.PagePoint;
import com.youaodu.template.common.service.PagePointService;
import org.springframework.stereotype.Service;

@Service
public class PagePointServiceImpl extends ServiceImpl<PagePointMapper, PagePoint> implements PagePointService {
}
