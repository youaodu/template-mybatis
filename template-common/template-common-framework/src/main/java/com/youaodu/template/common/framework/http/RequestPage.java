package com.youaodu.template.common.framework.http;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public interface RequestPage<T> {
    /**
     * 分页起始索引
     * @return
     */
    Integer getPageNum();

    /**
     * 分页结束索引大小
     * @return
     */
    Integer getPageSize();

    String getStart();

    String getEnd();

    T getModel();

}