package com.youaodu.template.common.entity.pojo.dto.admin;

import lombok.Data;

@Data
public class SettingsButtonDto {
    /**
     * 角色编号
     */
    private Long roleId;

    /**
     * 资源编号
     */
    private Long resId;

    /**
     * 可操作按钮集
     */
    private String[] buttons;
}
