package com.youaodu.template.common.entity.model;

import com.youaodu.template.common.framework.crud.BaseUser;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class AdminAccount extends BaseUser {

    @Column(columnDefinition = "bit(1) DEFAULT b'0' COMMENT '该账号是否需要发验证码'")
    private Boolean needSms;

}
