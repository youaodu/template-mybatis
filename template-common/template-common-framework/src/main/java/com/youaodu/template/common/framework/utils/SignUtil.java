package com.youaodu.template.common.framework.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Iterator;
import java.util.Map;


/**
 *  生活圈 加签工具类
 */
public class SignUtil {

    public  static String createSign(Map map,String secret){

        StringBuffer sf = new StringBuffer();
        if (map != null && map.keySet().size() > 0) {
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry<String, String>) iterator.next();
                sf.append(entry.getKey()+"="+entry.getValue()+"&");
            }
        }

        String s = sf.toString();
        //移除最后一个&，如果是md5加密，还要加上secret
        String s2 = s.substring(0, s.length() - 1)+secret;
        System.out.println(s2);
        String sign = DigestUtils.md5Hex(s2).toString().toUpperCase();

        return sign;

    }

}
