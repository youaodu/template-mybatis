package com.youaodu.template.wechat.utils;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.youaodu.template.common.framework.utils.RedisUtils;
import com.youaodu.template.common.framework.utils.SpringUtils;
import com.youaodu.template.wechat.bo.MenuBo;
import com.youaodu.template.wechat.config.WeChatConfig;
import com.youaodu.template.wechat.config.WeChatUrls;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.ImplicitUniqueKeyNameSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class WeChatUtil {

    private static RedisUtils redisUtils = SpringUtils.getBean(RedisUtils.class);

    private static WeChatConfig weChatConfig = SpringUtils.getBean(WeChatConfig.class);

    public static final String accesskeyName = "weChat_accessToken";


    public static String accessToken() {
        return redisUtils.getStr(accesskeyName);
    }

    /**
     * 刷新AccessToken
     */
    public static void reloadAccessToken() {
        Map<String, Object> requestParams = new HashMap<>();
        requestParams.put("grant_type", "client_credential");
        requestParams.put("appid", weChatConfig.getAppId());
        requestParams.put("secret", weChatConfig.getAppSecret());

        // 发送请求
        JSONObject response = JSONUtil.parseObj(HttpUtil.get(WeChatUrls.accessToken, requestParams));
        String accessToken = response.getStr("access_token");
        if (StrUtil.isNotBlank(accessToken)) {
            // token存储redis
            redisUtils.set(accesskeyName, accessToken, 3600L);
        }
    }

    /**
     * 设置buttons
     * @param menuBos
     */
    public static boolean settingButtons(List<MenuBo> menuBos) {
        Map<String, Object> requestParams = new HashMap<>();
        requestParams.put("button", boToMenu(menuBos));
        JSONObject response = JSONUtil.parseObj(HttpUtil.post(WeChatUrls.settingButtons, JSONUtil.toJsonStr(requestParams)));
        if (StrUtil.equals(response.getStr("errcode"), "0") && StrUtil.equals(response.getStr("errmsg"), "ok")) {
            return true;
        } else {
            log.error("设置失败 -> {}", response.toString());
            return false;
        }
    }

    /**
     * 当前菜单按钮集
     * @return
     */
    public static List<MenuBo> currentButtons() {
        Map<String, Object> requestParams = new HashMap<>();
        requestParams.put("access_token", accessToken());

        JSONObject response = JSONUtil.parseObj(HttpUtil.get(WeChatUrls.showButtons, requestParams));
        JSONObject buttonsObj = response.getJSONObject("selfmenu_info");

        if (buttonsObj != null)
            return menuToBo(buttonsObj);
        else
            return null;
    }

    private static List<Map<String, Object>> boToMenu(List<MenuBo> menus) {
        List<Map<String, Object>> result = new ArrayList<>();

        menus.forEach(it -> {
            // 转换按钮集
            HashMap<String, Object> resultItem = new HashMap<>();
            resultItem.put("type", it.getType());
            resultItem.put("name", it.getName());
            resultItem.put("key", it.getKey());
            resultItem.put("url", it.getUrl());

            if (CollUtil.isNotEmpty(it.getChildren())) {
                // 递归下级
                resultItem.put("sub_button", boToMenu(it.getChildren()));
            }
            result.add(resultItem);
        });
        return result;
    }

    /**
     * 微信返回的JSON转BO
     * @param buts
     * @return
     */
    private static List<MenuBo> menuToBo(JSONObject buts) {
        JSONArray tmpArray;

        // 解析JSONArray
        if (buts.getJSONArray("button") != null)
            tmpArray = buts.getJSONArray("button");
        else if (buts.getJSONArray("list") != null)
            tmpArray = buts.getJSONArray("list");
        else
            return null;

        return tmpArray.stream().map(it -> {
            JSONObject item = JSONUtil.parseObj(it.toString());
            MenuBo resultItem = new MenuBo();

            resultItem.setName(item.getStr("name"));
            resultItem.setType(item.getStr("type"));
            resultItem.setUrl(item.getStr("url"));
            resultItem.setKey(item.getStr("key"));

            if (item.getStr("sub_button") != null) {
                // 递归
                resultItem.setChildren(menuToBo(item.getJSONObject("sub_button")));
            }

            return resultItem;
        }).collect(Collectors.toList());
    }
}
