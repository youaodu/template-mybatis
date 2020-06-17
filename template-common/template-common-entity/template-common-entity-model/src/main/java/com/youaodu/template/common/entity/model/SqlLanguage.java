package com.youaodu.template.common.entity.model;

import com.youaodu.template.common.framework.crud.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class SqlLanguage extends BaseEntity {

    @Column(columnDefinition = "varchar(500) default '' comment 'sql语句'")
    private String sqlStatement;

    @Column(columnDefinition = "varchar(200) default '' comment 'sql语句标记'")
    private String sqlFlag;

    @Column(columnDefinition = "int(3) default 0 comment '执行顺序'")
    private Integer execIdx;

    @Column(columnDefinition = "varchar(500) default '' comment '返回参数集'")
    private String resultParams;
}
