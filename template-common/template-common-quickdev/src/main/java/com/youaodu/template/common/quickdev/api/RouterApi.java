package com.youaodu.template.common.quickdev.api;

import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpUtil;
import com.youaodu.template.common.framework.annotation.WhiteRequest;
import com.youaodu.template.common.framework.http.ResultMessage;
import com.youaodu.template.common.framework.utils.RequestUtils;
import com.youaodu.template.common.quickdev.biz.RouterBiz;
import org.apache.catalina.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RouterApi {

    @Autowired
    private RouterBiz routerBiz;

    @WhiteRequest
    @RequestMapping("/**")
    public ResultMessage router(HttpServletRequest request) {
        // 请求地址
        String requestPath = request.getServletPath();

        // 获取参数
        Map<String, Object> params = new HashMap<>();
        if (MapUtil.isNotEmpty(request.getParameterMap())) {
            request.getParameterMap().forEach((key, value) -> params.put(key, value[0]));
        } else {
            params.putAll(RequestUtils.getRawJsonObject(request));
        }

        // 请求方式
        String method = request.getMethod();
        String tokenStr = request.getHeader("Token");

        // 分发
        return routerBiz.exec(requestPath, params, method, tokenStr);
    }
}
