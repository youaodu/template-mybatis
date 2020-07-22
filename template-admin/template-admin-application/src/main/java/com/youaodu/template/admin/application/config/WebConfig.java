package com.youaodu.template.admin.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将访问/static/** 的路由映射到classpath:/static/ 目录下
        registry.addResourceHandler("/**").addResourceLocations("file:////Users/yoaotu/youao_project/template-mybatis/template-admin/template-admin-application/src/main/resources/");
    }

}