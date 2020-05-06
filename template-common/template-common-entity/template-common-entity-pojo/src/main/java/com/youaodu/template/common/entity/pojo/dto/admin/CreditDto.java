package com.youaodu.template.common.entity.pojo.dto.admin;

import cn.hutool.core.util.ArrayUtil;
import lombok.Data;

@Data
public class CreditDto {
    private Long roleId;

    private Long[] resIds;
}
