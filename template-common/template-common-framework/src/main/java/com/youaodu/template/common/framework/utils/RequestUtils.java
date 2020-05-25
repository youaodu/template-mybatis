package com.youaodu.template.common.framework.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RequestUtils {
    /**
     * 返回jsonObj参数
     * @param request
     * @return
     */
    public static JSONObject getRaw(HttpServletRequest request) {
        JSONObject paramsObj = null;
        try {
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            paramsObj = JSONUtil.parseObj(responseStrBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paramsObj;
    }
}
