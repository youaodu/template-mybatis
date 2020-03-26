package com.youaodu.template.common.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FileUtils {

    public static InputStream urlToInputStream(String urlStr) {
        URL url = null;
        InputStream inputstream = null;
        try {
            url = new URL(urlStr);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.setDoInput(true);//设置是否要从 URL 连接读取数据,默认为true
            uc.connect();
            inputstream = uc.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputstream;
    }
}
