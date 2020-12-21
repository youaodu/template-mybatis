package com.youaodu.template.common.quickdev.biz.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youaodu.template.common.entity.model.InterfaceDesign;
import com.youaodu.template.common.entity.model.SqlLanguage;
import com.youaodu.template.common.framework.http.ResultCode;
import com.youaodu.template.common.framework.http.ResultMessage;
import com.youaodu.template.common.framework.token.BuilderToken;
import com.youaodu.template.common.framework.token.Token;
import com.youaodu.template.common.quickdev.biz.RouterBiz;
import com.youaodu.template.common.quickdev.eum.SystemParamsNames;
import com.youaodu.template.common.service.InterfaceDesignService;
import com.youaodu.template.common.service.SqlLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RouterBizImpl implements RouterBiz {

    @Autowired
    private InterfaceDesignService interfaceDesignService;

    @Autowired
    private SqlLanguageService sqlLanguageService;

    /**
     * 请求分发
     *
     * @param requestPath
     * @param params
     * @param method
     * @param tokenStr
     * @return
     */
    @Override
    public ResultMessage exec(String requestPath, Map<String, Object> params, String method, String tokenStr) {
        InterfaceDesign interfaceDesign = interfaceDesignService.getOne(
                new LambdaQueryWrapper<InterfaceDesign>()
                        .eq(InterfaceDesign::getUrlPath, requestPath)
                        .eq(InterfaceDesign::getMethod, method)
        );

        Token token = null;
        // 校验需不需要token
        if (interfaceDesign.getIsToken() == 1) {
            if (StrUtil.isNotBlank(tokenStr)) {
                if (!BuilderToken.validateToken(tokenStr)) {
                    return ResultMessage.error(ResultCode.NO_PERMISS);
                }
                token = BuilderToken.analysisToken(tokenStr);
            }
        }

        // 校验参数对不对
        String[] paramsKeys = interfaceDesign.getParamKeys().split(",");
        for (String paramsKey : paramsKeys) {
            if (!params.containsKey(paramsKey)) {
                return ResultMessage.error(ResultCode.NO_PARAM);
            } else
                // 判断参数是否需要获取当前用户ID
                if (SystemParamsNames.CURRENT_ACCOUNT_ID.getName().equals(paramsKey)) {
                    params.put(SystemParamsNames.CURRENT_ACCOUNT_ID.getName(), token.getAccountId());
                }
        }

        List<SqlLanguage> sqlList = sqlLanguageService.list(
                new LambdaQueryWrapper<SqlLanguage>()
                        .eq(SqlLanguage::getSqlFlag, interfaceDesign.getSqlFlag())
                        .orderByAsc(SqlLanguage::getExecIdx)
        );

        if (interfaceDesign.getOpenAcid() == 1) {
            // 开启事务
            String[] sqls = sqlList.stream().map(SqlLanguage::getSqlStatement).toArray(String[]::new);
            boolean execResult = sqlLanguageService.acidExecSql(sqls, params);
            if (execResult) {
                return ResultMessage.ok();
            }
            return ResultMessage.error("事务执行失败");
        } else {
            // 判断执行单条
            if (sqlList.size() == 1) {
                return ResultMessage.ok(JSONUtil.toJsonStr(sqlLanguageService.execSql(sqlList.get(0).getSqlStatement(), params)), ResultCode.SUCCESS);
            } else {

            }
        }

        return null;
    }
}
