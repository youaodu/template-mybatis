package com.youaodu.template.common.framework.config.intercetor;

import com.youaodu.template.common.framework.annotation.WhiteRequest;
import com.youaodu.template.common.framework.token.BuilderToken;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {

    private final String TOKEN_NAME = "Token";

    /**
     * 前置拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tokenStr = request.getHeader(TOKEN_NAME);

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod method = (HandlerMethod) handler;
        // 不用校验 token 可过滤
        if (method.getMethod().isAnnotationPresent(WhiteRequest.class)) {
            return true;
        }

        // 校验token正确
        return BuilderToken.validateToken(tokenStr);
    }
}
