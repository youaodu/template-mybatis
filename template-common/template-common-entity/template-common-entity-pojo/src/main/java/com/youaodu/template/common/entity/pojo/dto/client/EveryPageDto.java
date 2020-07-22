package com.youaodu.template.common.entity.pojo.dto.client;

import com.youaodu.template.common.framework.token.Token;
import lombok.Data;

@Data
public class EveryPageDto {

    private String path; // 地址

    private String ip;

    private Token token;

    private Integer second; // 秒数

    private Long id;
}
