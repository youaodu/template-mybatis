package com.youaodu.template.common.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * * @create 2019-09-21 18:34
 */
public class SpringUtils  {

    /* logger */
    private static final Logger logger = LoggerFactory.getLogger(SpringUtils.class);

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringUtils.applicationContext = applicationContext;
        logger.info("spring applicationContext loading success");
    }

    /**
     * 获取Bean对象
     * * @time 18:39
     * @param tClass
     */
    public static <T> T getBean(Class<T> tClass) {
        return applicationContext.getBean(tClass);
    }

    /**
     * 获取Bean对象集合
     * @param <T>
     * @param tClass
     * @return
     */
    public static <T> List<T> getBeans(Class<T> tClass) {
        return new ArrayList<>(applicationContext.getBeansOfType(tClass).values());
    }

    /**
     * 获取Bean对象
     * * @time 18:39
     * @param tClass
     * @param beanName
     */
    public static <T> T getBean(String beanName, Class<T> tClass) {
        return applicationContext.getBean(beanName, tClass);
    }

    /**
     * 获取Bean对象
     * * @time 18:39
     * @param beanName
     */
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}
