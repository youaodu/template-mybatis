package com.youaodu.template.common.entity.pojo.dto.main;

import com.youaodu.template.common.framework.token.Token;
import lombok.Data;

import java.util.Map;

@Data
public class RootDto {

    private String method;

    private String path;

    private Map<String, Object> params;

    private String appCode;

    private Token tokenBean;
}
