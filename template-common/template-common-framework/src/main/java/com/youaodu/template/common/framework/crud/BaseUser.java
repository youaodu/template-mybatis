package com.youaodu.template.common.framework.crud;

import cn.hutool.crypto.SecureUtil;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 支持用户实体自定义
 * 这里只包含了两个必要属性(用户名, 密码)
 */

@Data
@MappedSuperclass
public class BaseUser extends BaseEntity {

    @Column(columnDefinition = "VARCHAR(30) COMMENT '用户名'")
    private String userName;

    @Column(columnDefinition = "VARCHAR(30) COMMENT '明文密码'")
    private String pwd;

    @Column(columnDefinition = "varchar(20) DEFAULT '' COMMENT '账号编号'")
    private String accountId;

    // 加密后密码
    @Column(columnDefinition = "VARCHAR(32) COMMENT '密文密码'")
    private String encryPwd;

    @Column(columnDefinition = "int(3) DEFAULT 0 COMMENT '冻结 0 未 1 已'")
    private Integer loginLock;

    public void setPwd(String pwd) {
        this.pwd = pwd;
        this.encryPwd = SecureUtil.md5(pwd).toUpperCase();
    }

}