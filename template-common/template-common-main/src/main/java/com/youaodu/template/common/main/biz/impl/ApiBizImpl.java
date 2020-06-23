package com.youaodu.template.common.main.biz.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youaodu.template.common.entity.model.InterfaceDesign;
import com.youaodu.template.common.entity.model.SqlLanguage;
import com.youaodu.template.common.entity.pojo.dto.main.RootDto;
import com.youaodu.template.common.framework.exception.BusinessException;
import com.youaodu.template.common.main.biz.ApiBiz;
import com.youaodu.template.common.service.InterfaceDesignService;
import com.youaodu.template.common.service.SqlLanguageService;
import com.youaodu.template.common.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApiBizImpl implements ApiBiz {

    @Autowired
    private SqlLanguageService sqlLanguageService;

    @Autowired
    private SystemConfigService systemConfigService;

    @Autowired
    private InterfaceDesignService interfaceDesignService;

    /**
     * 根路径
     * @param rootDto
     * @return
     */
    @Override
    public Map<String, Object> root(RootDto rootDto) {
        List<InterfaceDesign> interfaceList = interfaceDesignService.list(new LambdaQueryWrapper<InterfaceDesign>()
                .eq(InterfaceDesign::getAppCode, rootDto.getAppCode())
                .eq(InterfaceDesign::getMethod, rootDto.getMethod())
                .eq(InterfaceDesign::getUrlPath, rootDto.getPath())
        );

        // 判断接口
        if (CollUtil.isEmpty(interfaceList)) {
            throw new BusinessException("当前接口不存在");
        }
        if (interfaceList.size() > 1) {
            throw new BusinessException("当前接口出现多个, 请检查接口列表");
        }

        // 当前要操作的接口
        InterfaceDesign api = interfaceList.get(0);
        // 接口是否需token
        if (api.getIsToken() && rootDto.getTokenBean() == null) {
            throw new BusinessException("当前接口需要Token, 请携带token后重试");
        }
        List<SqlLanguage> sqlList = sqlLanguageService.list(new LambdaQueryWrapper<SqlLanguage>()
                .eq(SqlLanguage::getAppCode, rootDto.getAppCode())
                .eq(SqlLanguage::getSqlFlag, api.getSqlFlag())
                .orderByDesc(SqlLanguage::getExecIdx)
        );

        if (api.getOpenAcid()) {

        } else {

        }



        return null;
    }
}
