package com.youaodu.template.common.framework.http;

import lombok.Data;

/**
 * @author youao.du@gmail.com
 * @time 2020-01-03 21:32
 */
@Data
public class  BaseDto<T> implements RequestPage<T> {

    private Integer pageNum = 0;

    private Integer pageSize = 10;

    private T model;

    /**
     * 起始时间
     */
    private String start;

    /**
     * 结束时间
     */
    private String end;

    /**
     * 计算分页坐标方法
     */
    public void calcPage() {
        if (pageNum > 0) {
            this.pageNum = (this.pageNum - 1) * pageSize;
        }
    }
}
