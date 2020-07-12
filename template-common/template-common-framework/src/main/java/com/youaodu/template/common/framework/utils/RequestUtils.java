package com.youaodu.template.common.framework.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class RequestUtils {

    public static JSONObject getRawJsonObject(HttpServletRequest request) {
        String json = getRawJsonString(request);
        System.out.println(json);
        return JSONUtil.parseObj("{" + json + "}");
    }

    /**
     * 获取 request 中 json 字符串的内容
     *
     * @param request
     * @return : <code>byte[]</code>
     * @throws IOException
     */
    public static String getRawJsonString(HttpServletRequest request) {
        String submitMehtod = request.getMethod();
        // GET
        if ("GET".equals(submitMehtod)) {
            try {
                return new String(request.getQueryString().getBytes("iso-8859-1"), "utf-8").replaceAll("%22", "\"");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
            // POST
        } else {
            return getRawStr(request);
        }
    }


        /**
         * 描述:获取 post 请求内容
         * <pre>
         * 举例：
         * </pre>
         * @param request
         * @return
         * @throws IOException
         */
    public static String getRawStr(HttpServletRequest request){
        byte buffer[] = getRawBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        try {
            return new String(buffer, charEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 字节
     * @param request
     * @return
     * @throws IOException
     */
    public static byte[] getRawBytes(HttpServletRequest request) {
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {

            int readlen = 0;
            try {
                readlen = request.getInputStream().read(buffer, i,
                        contentLength);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }
}
