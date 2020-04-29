package com.youaodu.template.common.entity.model;

import com.youaodu.template.common.framework.crud.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * * @time 2019-12-29 19:28
 */
@Data
@Entity
public class Resources extends BaseEntity {

    @Column(columnDefinition = "BIGINT(10) DEFAULT 0 COMMENT '上级编号'")
    private Long pid;

    @Column(columnDefinition = "varchar(20) DEFAULT '' COMMENT '名字'")
    private String name;

    @Column(columnDefinition = "varchar(100) DEFAULT '' COMMENT '组件地址'")
    private String component;

    @Column(columnDefinition = "varchar(100) DEFAULT '' COMMENT '请求地址'")
    private String path;

    @Column(columnDefinition = "BIT DEFAULT b'1' COMMENT '是否显示'")
    private Boolean hide;

    @Column(columnDefinition = "int(3) DEFAULT '0' COMMENT '资源级别'")
    private Integer level;
}
