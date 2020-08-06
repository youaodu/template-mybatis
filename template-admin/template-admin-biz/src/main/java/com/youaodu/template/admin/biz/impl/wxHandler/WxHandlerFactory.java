package com.youaodu.template.admin.biz.impl.wxHandler;

import cn.hutool.extra.spring.SpringUtil;
import com.youaodu.template.common.framework.utils.SpringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WxHandlerFactory {

    /**
     * 工厂对象
     */
    private  Map<String, WxHandlerIfac> factory = new HashMap<>();

    /**
     * 工厂初始化
     */
    public WxHandlerFactory() {
        // 注册
        List<WxHandlerIfac> beans = SpringUtils.getBeans(WxHandlerIfac.class);
        beans.forEach(it -> {
            factory.put(it.getKey(), it);
        });
    }

    /**
     * 静态内部类单例
     */
    public static class Holder {
        public static WxHandlerFactory instance = new WxHandlerFactory();
    }

    /**
     * 在构造方法的时候，初始化好 需要的 ServiceFeeFactory
     * @return
     */
    public static WxHandlerFactory getInstance() {
        return Holder.instance;
    }

}
