package com.youaodu.template.wechat.bo;

import com.youaodu.template.wechat.eum.WxTypeEnum;
import lombok.Data;

import java.io.InputStream;

@Data
public class UploadForeverMaterialBo {

    private WxTypeEnum type;

    private String fileHttpUrl;

    private String fileLocalUrl;

    private InputStream inputStream;

    private String fileName;

}
