package com.youaodu.template.common.framework.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * * @create 2019-08-13 00:04
 */
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 获取
     * * @time 00:06
     * @params key
     */
    public String getStr(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取Long
     * * @time 16:48
     * @param key
     */
    public Long getLong(String key) {
        try {
            return Long.parseLong(redisTemplate.opsForValue().get(key));
        } catch (Exception e) {
            return null;
        }
    }

    public BigDecimal getBigDecimal(String key) {
        return new BigDecimal(redisTemplate.opsForValue().get(key));
    }

    /**
     * 数值增加
     * * @time 00:22
     * @param key
     * @param add
     */
    public Long increment(String key, Long add) {
        String str = getStr(key);
        if (!NumberUtil.isNumber(str)) {
            return null;
        }
        return redisTemplate.opsForValue().increment(key, add);
    }

    /**
     * 当字符串为Json格式时, 可转换对象 >>> 会返回空
     * * @time 00:08
     * @params [key, beanClass]
     */
    public <T> T getJsonToBean(String key, Class<T> beanClass) {
        String value = redisTemplate.opsForValue().get(key);
        if (JSONUtil.isJson(value)) {
            return JSONUtil.toBean(value, beanClass);
        }
        return null;
    }

    /**
     * 存值 key, value
     * * @time 00:21
     * @params [key, value]
     */
    public String set(String key, String value) {
        if (StrUtil.isNotBlank(key) && StrUtil.isNotBlank(value)) {
            redisTemplate.opsForValue().set(key, value);
            return value;
        }
        return null;
    }

    /**
     * 存值 key, value, time  >>>  时间单位: 秒
     * * @time 00:22
     * @params [key, value, time]
     */
    public void set(String key, String value, Long time) {
        if (StrUtil.isNotBlank(key) && StrUtil.isNotBlank(value)) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        }
    }

    /**
     * 存值 >>> JSON
     * * @time 00:23
     * @params [key, value]
     */
    public <T> void setBean(String key, T value) {
        if (StrUtil.isNotBlank(key) && BeanUtil.isEmpty(value)) {
            set(key, JSONUtil.toJsonStr(value));
        }
    }

    /**
     * 存值 >>> JSON 时间单位: 秒数
     * * @time 00:29
     * @params [key, value, time]
     */
    public <T> void setBean(String key, T value, Long time) {
        if (StrUtil.isNotBlank(key) && BeanUtil.isEmpty(value)) {
            set(key, JSONUtil.toJsonStr(value), time);
        }
    }
}
