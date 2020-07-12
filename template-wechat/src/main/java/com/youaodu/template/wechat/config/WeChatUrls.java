package com.youaodu.template.wechat.config;

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
}
