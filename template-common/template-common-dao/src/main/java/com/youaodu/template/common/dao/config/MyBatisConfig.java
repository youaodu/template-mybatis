package com.youaodu.template.common.dao.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.youaodu.template.common.dao.mapper", "com.gitee.sunchenbin.mybatis.actable.dao.*"})
@ComponentScan("com.gitee.sunchenbin.mybatis.actable.manager.*")
public class MyBatisConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}
