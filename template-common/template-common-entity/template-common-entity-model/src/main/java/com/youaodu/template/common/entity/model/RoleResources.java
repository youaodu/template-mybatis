package com.youaodu.template.common.entity.model;

import com.youaodu.template.common.framework.crud.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * * @time 2019-12-29 23:38
 */
@Data
@Entity
public class RoleResources extends BaseEntity {

    @Column(columnDefinition = "BIGINT(10) COMMENT '角色编号'")
    private Long roleId;

    @Column(columnDefinition = "BIGINT(10) COMMENT '资源编号'")
    private Long resourcesId;

    @Column(columnDefinition = "VARCHAR(100) DEFAULT '' COMMENT '显示按钮个'")
    private String buttons;
}
