package com.youaodu.template.common.entity.model;

import com.youaodu.template.common.framework.crud.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 部门表
 */

@Data
@Entity
public class Department extends BaseEntity {

    @Column(columnDefinition = "varchar(30) default '' comment '部门标记'")
    private String departmentCode;

    @Column(columnDefinition = "varchar(30) default '' comment '部门描述'")
    private String departmentDesc;

}
