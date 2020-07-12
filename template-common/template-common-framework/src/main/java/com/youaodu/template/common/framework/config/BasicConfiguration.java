package com.youaodu.template.common.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.youaodu.template.common.framework.config.mapper"})
@EntityScan({"com.youaodu.template.common.framework.config.entity"})
public class BasicConfiguration {

}
