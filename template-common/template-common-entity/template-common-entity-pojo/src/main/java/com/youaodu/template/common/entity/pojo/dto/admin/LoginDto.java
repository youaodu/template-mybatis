package com.youaodu.template.common.entity.pojo.dto.admin;

import cn.hutool.crypto.digest.MD5;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDto {

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String pwd;

    public static void main(String[] args) {
        MD5 md5 = MD5.create();
        String admin = md5.digestHex("admin").toUpperCase();
        System.out.println(admin);
    }
}


