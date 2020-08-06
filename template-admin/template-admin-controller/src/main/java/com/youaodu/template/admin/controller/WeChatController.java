package com.youaodu.template.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.XmlUtil;
import com.youaodu.template.admin.biz.WeChatBiz;
import com.youaodu.template.admin.biz.impl.wxHandler.WxHandlerFactory;
import com.youaodu.template.admin.biz.impl.wxHandler.WxHandlerIfac;
import com.youaodu.template.common.entity.pojo.dto.admin.JsAuthDto;
import com.youaodu.template.common.entity.pojo.dto.admin.SettingsButtonsDto;
import com.youaodu.template.common.entity.pojo.dto.admin.WeChatNoticeDto;
import com.youaodu.template.common.framework.annotation.ApiLog;
import com.youaodu.template.common.framework.annotation.WhiteRequest;
import com.youaodu.template.common.framework.http.ResultMessage;
import com.youaodu.template.common.framework.utils.ConvertUtils;
import com.youaodu.template.common.framework.utils.RequestUtils;
import com.youaodu.template.common.framework.utils.SpringUtils;
import com.youaodu.template.wechat.bo.MenuBo;
import com.youaodu.template.wechat.bo.ScriptAuthBo;
import com.youaodu.template.wechat.bo.UploadTmpMaterialBo;
import com.youaodu.template.wechat.bo.UploadTmpMaterialBoVo;
import com.youaodu.template.wechat.eum.WxTypeEnum;
import com.youaodu.template.wechat.utils.WeChatUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/wechat")
public class WeChatController {

    @Autowired
    private WeChatBiz weChatBiz;


    /**
     * js微信授权
     *
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
     *
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
     *
     * @return
     */
    @GetMapping("/showButtons")
    @ApiLog(desc = "全部公众号按钮")
    public ResultMessage showButtons() {
        return ResultMessage.ok(WeChatUtil.currentButtons());
    }

    /**
     * 微信回调推送
     *
     * @param request
     * @return
     */
    @WhiteRequest
    @RequestMapping("/noticeWeChat")
    public String noticeWeChat(HttpServletRequest request) {
        List<WxHandlerIfac> beans = SpringUtils.getBeans(WxHandlerIfac.class);
        System.out.println(beans.size());


        String openid = request.getParameter("openid");
        String echostr = request.getParameter("echostr");
        if (StringUtils.isEmpty(openid)) {
            return echostr;
        }

        new Thread(() -> {
            System.out.println("-----");
            WeChatNoticeDto weChatNoticeDto = BeanUtil.mapToBeanIgnoreCase(XmlUtil.xmlToMap(RequestUtils.getRawStr(request)), WeChatNoticeDto.class, false);
            weChatBiz.noticeWeChat(weChatNoticeDto);
        }).start();
        return "SUCCESS";
    }

    @PostMapping("/uploadTmpFile")
    public ResultMessage uploadTmpFile(MultipartFile file) {
        UploadTmpMaterialBo uploadTmpMaterialBo = new UploadTmpMaterialBo();
        uploadTmpMaterialBo.setFileName(file.getOriginalFilename());
        uploadTmpMaterialBo.setType(WxTypeEnum.query(file.getContentType().split("/")[0]));
        try {
            uploadTmpMaterialBo.setInputStream(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        UploadTmpMaterialBoVo uploadTmpMaterialBoVo = WeChatUtil.uploadTmpMaterial(uploadTmpMaterialBo);
        return ResultMessage.ok();
    }

}
