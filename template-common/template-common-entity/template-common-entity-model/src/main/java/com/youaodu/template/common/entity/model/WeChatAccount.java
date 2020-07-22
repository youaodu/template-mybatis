package com.youaodu.template.common.entity.model;

import com.youaodu.template.common.framework.crud.BaseUser;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class WeChatAccount extends BaseUser {

    @Column(columnDefinition = "varchar(30) default '' comment '微信公众号唯一ID'")
    private String openId;

    @Column(columnDefinition = "varchar(300) default '' comment '头像'")
    private String headImg;

    @Column(columnDefinition = "varchar(50) default '' comment '昵称'")
    private String nickName;
}
