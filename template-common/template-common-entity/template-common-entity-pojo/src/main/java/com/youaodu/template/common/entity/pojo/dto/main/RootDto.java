package com.youaodu.template.common.entity.pojo.dto.main;

import lombok.Data;

import java.util.Map;

@Data
public class RootDto {

    private String method;

    private String path;

    private Map<String, Object> params;

}
