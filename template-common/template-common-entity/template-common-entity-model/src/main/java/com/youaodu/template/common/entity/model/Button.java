package com.youaodu.template.common.entity.model;

import com.youaodu.template.common.framework.crud.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Button extends BaseEntity {

    @Column(columnDefinition = "varchar(30) default '' COMMENT '按钮名'")
    private String name;

    @Column(columnDefinition = "varchar(30) default '' COMMENT '按钮标记'")
    private String flag;

}
