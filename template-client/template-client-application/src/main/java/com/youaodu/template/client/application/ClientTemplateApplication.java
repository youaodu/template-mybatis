package com.youaodu.template.client.application;

import cn.hutool.extra.spring.SpringUtil;
import com.youaodu.template.common.framework.utils.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EntityScan({"com.youaodu.template.common.entity.model"})
@SpringBootApplication(scanBasePackages = "com.youaodu.template")
public class ClientTemplateApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ClientTemplateApplication.class, args);
        SpringUtils.setApplicationContext(run);
    }

}
