package com.youaodu.template.common.framework.http;

import java.util.List;

public class ResultPage<T> {
    private List<T> list;

    private Long total;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
