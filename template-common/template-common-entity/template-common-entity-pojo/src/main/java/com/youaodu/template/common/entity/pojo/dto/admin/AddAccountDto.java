package com.youaodu.template.common.entity.pojo.dto.admin;

import lombok.Data;

@Data
public class AddAccountDto {

    /**
     * 用户名
     */
    private String accountName;

    /**
     * 密码
     */
    private String pwd;

}
