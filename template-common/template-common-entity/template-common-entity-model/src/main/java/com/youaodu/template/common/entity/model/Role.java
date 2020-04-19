package com.youaodu.template.common.entity.model;

import com.youaodu.template.common.framework.crud.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * * @time 2019-12-29 19:24
 */
@Data
@Entity
public class Role extends BaseEntity {

    @Column(columnDefinition = "varchar(20) default '' comment '代码'")
    private String code;

    @Column(columnDefinition = "varchar(50) default '' comment '描述信息'")
    private String descr;
}
