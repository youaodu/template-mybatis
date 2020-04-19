package com.youaodu.template.common.framework.utils;

import cn.hutool.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RequestUtils {
    /**
     * 返回jsonObj参数
     * @param request
     * @return
     */
    public static JSONObject getRequestParamsObj(HttpServletRequest request) {
        JSONObject paramsObj = null;
        try {
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            System.out.println(responseStrBuilder.toString());
//            paramsObj = JSONUtil.parseObj(responseStrBuilder.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return paramsObj;
    }
}
