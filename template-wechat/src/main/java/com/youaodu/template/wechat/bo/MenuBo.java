package com.youaodu.template.wechat.bo;

import lombok.Data;

import java.util.List;

@Data
public class MenuBo {

    /**
     * 子节点
     */
    private List<MenuBo> children;

    /**
     * 类型 view click miniprogram
     */
    private String type;

    /**
     * 菜单标题
     */
    private String name;

    /**
     * 跳转地址
     */
    private String url;

    /**
     * 菜单Key
     */
    private String key;

}
