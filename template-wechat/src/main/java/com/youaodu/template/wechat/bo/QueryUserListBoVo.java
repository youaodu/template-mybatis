package com.youaodu.template.wechat.bo;

import lombok.Data;

import java.util.List;

@Data
public class QueryUserListBoVo {

    private List<String> openIds; // openId 列表

    private Integer total; // 用户总数

    private Integer currTotal; // 当前获取总数
}
