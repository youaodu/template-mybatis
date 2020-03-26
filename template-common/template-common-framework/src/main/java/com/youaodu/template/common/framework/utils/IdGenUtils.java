package com.youaodu.template.common.framework.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;


public class IdGenUtils {

    /**
     * 生成ID
     * @param idBizCode >>> 业务代码
     * @return
     */
    public static String genId(IdBizCode idBizCode) {
        Integer codeNum = idBizCode.getCodeNum();

        // 前缀
        StringBuilder prefix = new StringBuilder();
        prefix.append(codeNum);
        DateTime date = DateUtil.date(System.currentTimeMillis());
        // 年
        prefix.append(StrUtil.toString(date.getField(DateField.YEAR)).substring(2));
        // 一年中的第几天
        int dayOfYear = date.getField(DateField.DAY_OF_YEAR);
        prefix.append(dayOfYear);
        // 一天中的第几个小时
        int hourOfDay = date.getField(DateField.HOUR_OF_DAY);
        prefix.append(hourOfDay);
        RedisUtils redisUtils = SpringUtils.getBean(RedisUtils.class);
        Long increment = redisUtils.increment(prefix.toString(), 1L);
        if (increment == null) {
            increment = 1L;
            redisUtils.set(prefix.toString(), StrUtil.toString(increment), 60 * 60L);
        }

        // 进行补位
        String after = StringUtil.patchPosition(increment.intValue(), 7);
        prefix.append(after);
        return prefix.toString();
    }



    public static void main(String[] args) {
        IdGenUtils idGenUtils = new IdGenUtils();
    }
}
