package com.youaodu.template.wechat.task;

import com.youaodu.template.wechat.utils.WeChatUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeChatTask {

    /**
     * 每小时刷新
     */
    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void loadAccessToken() {
        WeChatUtil.reloadAccessToken();
    }

}
