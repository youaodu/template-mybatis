package com.youaodu.template.common.quickdev.biz;

import com.youaodu.template.common.framework.http.ResultMessage;

import java.util.Map;

public interface RouterBiz {
    ResultMessage exec(String requestPath, Map<String, Object> params, String method, String tokenStr);
}
