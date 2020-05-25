package com.youaodu.template.common.entity.pojo.dto.admin;

import lombok.Data;

@Data
public class AddRoleDto {

    private String code;

    private String descr;

    private Integer level = 1;
}
