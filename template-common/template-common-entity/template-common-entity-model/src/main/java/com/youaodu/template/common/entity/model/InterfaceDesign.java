package com.youaodu.template.common.entity.model;

import com.youaodu.template.common.framework.crud.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 接口设计表
 */

@Data
@Entity
public class InterfaceDesign extends BaseEntity {

    @Column(columnDefinition = "varchar(500) default '' comment '请求地址'")
    private String urlPath;

    @Column(columnDefinition = "varchar(20) default '' comment '请求方式'")
    private String method;

    @Column(columnDefinition = "varchar(500) default '' comment '请求参数'")
    private String paramKeys;

    @Column(columnDefinition = "varchar(200) default '' comment 'sql标记'")
    private String sqlFlag;

    @Column(columnDefinition = "bit(1) default b'0' comment '是否开启事务'")
    private Boolean openAcid;

    @Column(columnDefinition = "varchar(30) default '' comment '应用标记'")
    private String appCode;

    @Column(columnDefinition = "bit(1) DEFAULT b'0' COMMENT '该接口是否需要token请求'")
    private Boolean isToken;

}
