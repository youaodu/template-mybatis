package com.youaodu.template.common.entity.model.eum;

import cn.hutool.core.util.StrUtil;

public enum RequestMethod {
    GET("GET"),
    HEAD("HEAD"),
    POST("POST"),
    PUT("PUT"),
    PATCH("PATCH"),
    DELETE("DELETE"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE"),
    OTHER("其他")
    ;

    RequestMethod(String method) {
        this.method = method;
    }

    public RequestMethod query(String method){
        for (RequestMethod item : RequestMethod.values()) {
            if (StrUtil.equals(item.getMethod(), method)) {
                return item;
            }
        }
        return null;
    }

    private String method;

    public String getMethod() {
        return method;
    }

}
