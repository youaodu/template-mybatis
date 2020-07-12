package com.youaodu.template.admin.controller;

import com.youaodu.template.common.entity.pojo.dto.admin.JsAuthDto;
import com.youaodu.template.common.framework.annotation.ApiLog;
import com.youaodu.template.common.framework.annotation.WhiteRequest;
import com.youaodu.template.common.framework.http.ResultMessage;
import com.youaodu.template.wechat.bo.ScriptAuthBo;
import com.youaodu.template.wechat.bo.ScriptAuthBoVo;
import com.youaodu.template.wechat.utils.WeChatUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wechat")
public class WeChatController {


    @WhiteRequest
    @GetMapping("/jsAuth")
    @ApiLog(desc = "js微信授权")
    public ResultMessage jsAuth(JsAuthDto jsAuthDto) {
        ScriptAuthBo scriptAuthBo = new ScriptAuthBo();
        scriptAuthBo.setCurrUrl(jsAuthDto.getCurrUrl());
        return ResultMessage.ok(WeChatUtil.scriptAuth(scriptAuthBo));
    }

}
