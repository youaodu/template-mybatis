package com.youaodu.template.common.entity.model;

import com.youaodu.template.common.framework.crud.BaseEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * * @time 2019-12-29 23:36
 */
@Data
@Entity
public class AccountRole extends BaseEntity {
    @Column(columnDefinition = "varchar(20) default '' COMMENT '用户编号'")
    private String accountId;

    @Column(columnDefinition = "bigint(10) default 0 COMMENT '角色编号'")
    private Long roleId;
}
