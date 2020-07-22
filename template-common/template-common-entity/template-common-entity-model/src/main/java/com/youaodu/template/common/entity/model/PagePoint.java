package com.youaodu.template.common.entity.model;

import com.youaodu.template.common.framework.crud.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class PagePoint extends BaseEntity {

    @Column(columnDefinition = "varchar(20) default '' comment '操作用户Id'")
    private String accountId;

    @Column(columnDefinition = "bigint(10) default 0 comment '停留秒数'")
    private Integer second;

    @Column(columnDefinition = "varchar(100) default '' comment '页面路径'")
    private String pagePath;

    @Column(columnDefinition = "varchar(20) default '' comment '请求ip'")
    private String ip;

    @Column(columnDefinition = "varchar(200) default '' comment '描述信息'")
    private String descr;
}
