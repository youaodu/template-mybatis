package com.youaodu.template.client.controller;

import com.youaodu.template.client.biz.WechatBiz;
import com.youaodu.template.common.entity.pojo.dto.admin.JsAuthDto;
import com.youaodu.template.common.entity.pojo.dto.client.UserInfoDto;
import com.youaodu.template.common.framework.annotation.ApiLog;
import com.youaodu.template.common.framework.annotation.WhiteRequest;
import com.youaodu.template.common.framework.http.ResultMessage;
import com.youaodu.template.wechat.bo.ScriptAuthBo;
import com.youaodu.template.wechat.utils.WeChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wechat")
public class WeChatController {

    @Autowired
    private WechatBiz wechatBiz;

    /**
     * 获取用户信息
     * @param userInfoDto
     * @return
     */
    @WhiteRequest
    @PostMapping("/userInfo")
    public ResultMessage userInfo(@RequestBody UserInfoDto userInfoDto) {
        return ResultMessage.ok(wechatBiz.userInfo(userInfoDto));
    }

    /**
     * js微信授权
     * @param jsAuthDto
     * @return
     */
    @WhiteRequest
    @GetMapping("/jsAuth")
    public ResultMessage jsAuth(JsAuthDto jsAuthDto) {
        ScriptAuthBo scriptAuthBo = new ScriptAuthBo();
        scriptAuthBo.setCurrUrl(jsAuthDto.getCurrUrl());
        return ResultMessage.ok(WeChatUtil.scriptAuth(scriptAuthBo));
    }
}
