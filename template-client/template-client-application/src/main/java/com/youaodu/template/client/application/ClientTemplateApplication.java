package com.youaodu.template.client.application;

import cn.hutool.extra.spring.SpringUtil;
import com.youaodu.template.common.framework.utils.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.youaodu.template")
public class ClientTemplateApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ClientTemplateApplication.class, args);
        SpringUtils.setApplicationContext(run);
    }

}
