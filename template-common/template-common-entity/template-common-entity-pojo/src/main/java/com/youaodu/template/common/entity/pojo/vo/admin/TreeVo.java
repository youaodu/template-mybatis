package com.youaodu.template.common.entity.pojo.vo.admin;

import lombok.Data;

import java.util.List;

@Data
public class TreeVo {

    private String name;

    private boolean hide;

    private String buttons;

    private String component;

    private String path;

    private List<TreeVo> children;
}
