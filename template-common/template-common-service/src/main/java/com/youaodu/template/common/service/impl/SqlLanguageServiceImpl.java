package com.youaodu.template.common.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youaodu.template.common.dao.mapper.SqlLanguageMapper;
import com.youaodu.template.common.entity.model.SqlLanguage;
import com.youaodu.template.common.service.SqlLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class SqlLanguageServiceImpl extends ServiceImpl<SqlLanguageMapper, SqlLanguage> implements SqlLanguageService {

    @Autowired
    private SqlLanguageMapper sqlLanguageMapper;

    /**
     * 执行Sql
     * @param sql
     * @param params
     * @return
     */
    @Override
    public String execSql(String sql, Map<String, Object> params) {
        return JSONUtil.toJsonStr(sqlLanguageMapper.execSql(sql, params));
    }

    /**
     * 多个sql执行 事务
     * @param sql
     * @param params
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean acidExecSql(String[] sql, Map<String, Object> params) {
        try {
            for (String item : sql) {
                execSql(item, params);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
