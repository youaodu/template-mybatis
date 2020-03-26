package com.youaodu.template.common.framework.utils;

import cn.hutool.core.util.StrUtil;

public class StringUtil {


    public static String patchPosition(int num, int length) {
        String numStr = StrUtil.toString(num);
        if (length > numStr.length()) {
            StringBuilder sb = new StringBuilder();
            int diff = length - numStr.length();
            // 添加补位0
            for (int i = 0; i < diff; i++) {
                sb.append("0");
            }
            sb.append(numStr);
            return sb.toString();
        }
        return StrUtil.toString(num);
    }

    public static void main(String[] args) {
        String s = patchPosition(199, 6);
        System.out.println(s);
    }
}
