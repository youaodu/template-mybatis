package com.youaodu.template.common.framework.http;

import com.youaodu.template.common.framework.config.intercetor.TokenInterceptor;
import com.youaodu.template.common.framework.config.mapper.ApiLoggerMapper;
import com.youaodu.template.common.framework.token.TokenResolvers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")    //允许所有前端站点调用
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .maxAge(1728000);
    }

    /**
     * 解析参数所用
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new TokenResolvers());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // token 拦截器
        registry.addInterceptor(new TokenInterceptor());
    }
}
