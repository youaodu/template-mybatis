package com.youaodu.template.common.entity.pojo.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddAccountDto {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String accountName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String pwd;

}
