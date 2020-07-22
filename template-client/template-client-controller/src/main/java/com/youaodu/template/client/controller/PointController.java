package com.youaodu.template.client.controller;

import com.youaodu.template.client.biz.PointBiz;
import com.youaodu.template.common.entity.pojo.dto.client.EveryPageDto;
import com.youaodu.template.common.framework.http.ResultMessage;
import com.youaodu.template.common.framework.token.Token;
import com.youaodu.template.common.framework.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    private PointBiz pointBiz;

    @PostMapping("/everyPage")
    public ResultMessage everyPage(Token token, EveryPageDto everyPageDto, HttpServletRequest request) {
        everyPageDto.setToken(token);
        everyPageDto.setIp(IpUtil.getIpAddr(request));
        return ResultMessage.ok(pointBiz.everyPage(everyPageDto));
    }

}
