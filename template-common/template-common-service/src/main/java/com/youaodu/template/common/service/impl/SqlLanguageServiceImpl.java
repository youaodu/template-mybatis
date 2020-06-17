package com.youaodu.template.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youaodu.template.common.dao.mapper.SqlLanguageMapper;
import com.youaodu.template.common.entity.model.SqlLanguage;
import com.youaodu.template.common.service.SqlLanguageService;
import org.springframework.stereotype.Service;

@Service
public class SqlLanguageServiceImpl extends ServiceImpl<SqlLanguageMapper, SqlLanguage> implements SqlLanguageService {
}
