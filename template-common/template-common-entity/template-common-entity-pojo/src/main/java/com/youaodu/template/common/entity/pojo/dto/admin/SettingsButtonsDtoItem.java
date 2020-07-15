package com.youaodu.template.common.entity.pojo.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class SettingsButtonsDtoItem {

    private List<SettingsButtonsDtoItem> children; // 子节点

    @NotBlank(message = "类型不能为空")
    private String type; // 类型 view click miniprogram

    @NotBlank(message = "菜单标题")
    private String name; // 菜单标题

    @NotBlank(message = "跳转URL")
    private String url; // 跳转地址

    @NotBlank(message = "菜单Key")
    private String key; // 菜单Key
}
