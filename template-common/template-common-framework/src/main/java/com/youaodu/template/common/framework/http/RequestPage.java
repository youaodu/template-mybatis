package com.youaodu.template.common.framework.http;

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