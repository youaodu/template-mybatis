package com.youaodu.template.admin.controller;

import com.youaodu.template.common.entity.pojo.dto.admin.JsAuthDto;
import com.youaodu.template.common.entity.pojo.dto.admin.SettingsButtonsDto;
import com.youaodu.template.common.framework.annotation.ApiLog;
import com.youaodu.template.common.framework.annotation.WhiteRequest;
import com.youaodu.template.common.framework.http.ResultMessage;
import com.youaodu.template.common.framework.utils.ConvertUtils;
import com.youaodu.template.wechat.bo.MenuBo;
import com.youaodu.template.wechat.bo.ScriptAuthBo;
import com.youaodu.template.wechat.utils.WeChatUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/wechat")
public class WeChatController {


    /**
     * js微信授权
     * @param jsAuthDto
     * @return
     */
    @WhiteRequest
    @GetMapping("/jsAuth")
    @ApiLog(desc = "js微信授权")
    public ResultMessage jsAuth(JsAuthDto jsAuthDto) {
        ScriptAuthBo scriptAuthBo = new ScriptAuthBo();
        scriptAuthBo.setCurrUrl(jsAuthDto.getCurrUrl());
        return ResultMessage.ok(WeChatUtil.scriptAuth(scriptAuthBo));
    }

    /**
     * 设置微信公众号
     * @return
     */
    @ApiLog(desc = "设置公众号按钮")
    @PostMapping("/settingsButtons")
    public ResultMessage settingsButtons(@Valid @RequestBody SettingsButtonsDto settingsButtonsDto) {
        List<MenuBo> menuBos = ConvertUtils.convertList(settingsButtonsDto.getButtons(), MenuBo.class);
        WeChatUtil.settingButtons(menuBos);
        return ResultMessage.ok();
    }

    /**
     * 显示全部按钮集
     * @return
     */
    @GetMapping("/showButtons")
    @ApiLog(desc = "全部公众号按钮")
    public ResultMessage showButtons() {
        return ResultMessage.ok(WeChatUtil.currentButtons());
    }



    /**
     * 微信回调推送
     * @param request
     * @return
     */
    @WhiteRequest
    @PostMapping("/noticeWeChat")
    public String noticeWeChat(HttpServletRequest request) {

        return "SUCCESS";
    }

    @WhiteRequest
    @RequestMapping("/check")
    public String check(HttpServletRequest request) {
        return request.getParameter("echostr");
    }

}
