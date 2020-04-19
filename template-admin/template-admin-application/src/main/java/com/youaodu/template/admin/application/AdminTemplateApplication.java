package com.youaodu.template.admin.application;

import com.youaodu.template.common.framework.utils.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@EnableScheduling
@EntityScan({"com.youaodu.template.common.entity.model"})
@SpringBootApplication(scanBasePackages = "com.youaodu.template")
public class AdminTemplateApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AdminTemplateApplication.class, args);
        SpringUtils.setApplicationContext(run);
    }

}
