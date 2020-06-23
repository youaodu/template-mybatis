package com.youaodu.template.common.framework.token;

import cn.hutool.core.util.StrUtil;
import com.youaodu.template.common.framework.exception.BusinessException;
import com.youaodu.template.common.framework.exception.TokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 把token解析为入参
 * * @time 2019-12-29 16:19
 */
public class TokenResolvers extends HandlerMethodArgumentResolverComposite implements HandlerMethodArgumentResolver {

    private static final String TOKEN_NAME = "Token";

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(TokenResolvers.class);

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Token.class);
    }

    /**
     * 解析token值。返回token
     * @param parameter
     * @param mavContainer
     * @param webRequest
     * @param binderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String tokenString = webRequest.getHeader(TOKEN_NAME);
        if (StrUtil.isBlank(tokenString)) {
            return null;
        }
        if (!BuilderToken.validateToken(tokenString)) {
            logger.warn(tokenString);
            return null;
        }
        return BuilderToken.analysisToken(tokenString);
    }
}
