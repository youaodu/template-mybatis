package com.youaodu.template.common.framework.utils;

import java.util.Iterator;
import java.util.Map;

/**
 * 参数工具类
 */
public class ParamUtils {


    public static String toRequestParams(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        params.forEach((key, value) -> {
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("&");
        });
        String tmpStr = sb.toString();
        // 移除最后一个&
        return tmpStr.substring(0, tmpStr.length() - 1);
    }
}
