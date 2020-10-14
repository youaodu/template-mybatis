package com.youaodu.template.common.entity.model;

import com.youaodu.template.common.framework.crud.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class KeyWordReply extends BaseEntity {

    @Column(columnDefinition = "varchar(30) default '' comment '关键词'")
    private String keyword;

    @Column(columnDefinition = "varchar(30) default '' comment '回复类型'")
    private String replyType;

    @Column(columnDefinition = "varchar(30) default '' comment '回复内容'")
    private Integer replyContent;

}
