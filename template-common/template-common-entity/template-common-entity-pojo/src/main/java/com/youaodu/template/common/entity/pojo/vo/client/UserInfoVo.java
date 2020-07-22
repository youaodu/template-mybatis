package com.youaodu.template.common.entity.pojo.vo.client;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserInfoVo {

    private String nickName; // 用户昵称

    private String headImg; // 头像

    private String tokenStr; // Token
}
