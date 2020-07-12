package com.youaodu.template.admin.application;

import com.youaodu.template.common.framework.utils.SpringUtils;
import com.youaodu.template.wechat.utils.WeChatUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@EntityScan({"com.youaodu.template.common.entity.model"})
@SpringBootApplication(scanBasePackages = "com.youaodu.template")
public class AdminTemplateApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AdminTemplateApplication.class, args);
        SpringUtils.setApplicationContext(run);

        init();
    }

    /**
     * 系统内部初始化
     */
    private static void init() {
        // 加载accessToekn
        WeChatUtil.reloadAccessToken();
    }

}
