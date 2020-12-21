package com.youaodu.template.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.youaodu.template.common.entity.model.SqlLanguage;

import java.util.Map;

public interface SqlLanguageService extends IService<SqlLanguage> {

    String execSql(String sql, Map<String, Object> params);

    boolean acidExecSql(String[] sql, Map<String, Object> params);
}
