package com.youaodu.template.client.biz;

import com.youaodu.template.common.entity.pojo.dto.client.EveryPageDto;
import com.youaodu.template.common.entity.pojo.vo.client.EveryPageVo;

public interface PointBiz {
    EveryPageVo everyPage(EveryPageDto everyPageDto);
}
