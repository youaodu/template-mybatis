package com.youaodu.template.common.framework.config.entity;

import com.youaodu.template.common.framework.crud.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 接口日志
 */

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class ApiLogger extends BaseEntity {

    @Column(columnDefinition = "varchar(100) default '' comment '接口地址'")
    private String apiPath;

    @Column(columnDefinition = "varchar(300) default '' comment '请求参数'")
    private String params;

    @Column(columnDefinition = "varchar(20) default '' comment '请求方式'")
    private String method;

    @Column(columnDefinition = "varchar(30) default '' comment '用户名'")
    private String accountName;

    @Column(columnDefinition = "varchar(30) default '' comment '用户ID'")
    private String accountId;

    @Column(columnDefinition = "varchar(50) default '' comment '接口描述信息'")
    private String apiDescr;

    @Column(columnDefinition = "varchar(50) default '' comment 'IP地址'")
    private String ipAddress;
}
