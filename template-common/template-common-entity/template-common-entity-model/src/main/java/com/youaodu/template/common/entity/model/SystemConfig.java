package com.youaodu.template.common.entity.model;

import com.youaodu.template.common.framework.crud.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 系统配置
 */

@Data
@Entity
public class SystemConfig extends BaseEntity {

    @Column(columnDefinition = "varchar(20) default '' comment '应用名称'")
    private String appName;

    @Column(columnDefinition = "varchar(20) default '' comment '应用标记'")
    private String appCode;

}
