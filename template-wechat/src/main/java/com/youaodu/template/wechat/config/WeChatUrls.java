package com.youaodu.template.wechat.config;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.TreeMap;

public class WeChatUrls {

    /**
     * 获取access token
     */
    public static final String accessToken = "https://api.weixin.qq.com/cgi-bin/token";

    /**
     * jsapi_ticket
     */
    public static final String jsapiTicket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";

    /**
     * 设定公众号按钮
     */
    public static final String settingButtons = "https://api.weixin.qq.com/cgi-bin/menu/create";

    /**
     * 获取按钮集
     */
    public static final String showButtons = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info";

    /**
     * 获取openId
     */
    public static final String openId = "https://api.weixin.qq.com/sns/oauth2/access_token";

    /**
     * 获取用户信息
     */
    public static final String userInfo = "https://api.weixin.qq.com/cgi-bin/user/info";

    /**
     * 获取用户列表
     */
    public static final String userList = "https://api.weixin.qq.com/cgi-bin/user/get";

    /**
     * 临时文件上传
     */
    public static final String fileTmpUpload = "https://api.weixin.qq.com/cgi-bin/media/upload";

    /**
     * 永久文件上传
     */
    public static final String fileForverUpload = "https://api.weixin.qq.com/cgi-bin/material/add_material";

    /**
     * 给用户发信息
     */
    public static final String sendMsgToUser = "https://api.weixin.qq.com/cgi-bin/message/custom/send";
}
