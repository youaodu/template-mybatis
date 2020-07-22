package com.youaodu.template.client.biz.impl;

import com.youaodu.template.client.biz.PointBiz;
import com.youaodu.template.common.entity.model.PagePoint;
import com.youaodu.template.common.entity.pojo.dto.client.EveryPageDto;
import com.youaodu.template.common.entity.pojo.vo.client.EveryPageVo;
import com.youaodu.template.common.service.PagePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointBizImpl implements PointBiz {

    @Autowired
    private PagePointService pagePointService;

    /**
     * 每个页面的埋点
     * @param everyPageDto
     * @return
     */
    @Override
    public EveryPageVo everyPage(EveryPageDto everyPageDto) {
        // 拼接埋点信息
        PagePoint saveBean = new PagePoint();
        saveBean.setAccountId(everyPageDto.getToken().getAccountId());
        saveBean.setIp(everyPageDto.getIp());
        saveBean.setPagePath(everyPageDto.getPath());
        return null;
    }
}
