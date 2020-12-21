package com.youaodu.template.common.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youaodu.template.common.entity.model.SqlLanguage;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface SqlLanguageMapper extends BaseMapper<SqlLanguage> {

    Object execSql(String sql, Map<String, Object> params);
}
