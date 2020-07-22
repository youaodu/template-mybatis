package com.youaodu.template.wechat.bo;

import lombok.Data;

@Data
public class QueryUserInfoByOpenIdBoVo {

    private String openid; // 用户的唯一标识

    private String nickname; // 用户昵称

    private Integer sex; // 性别 1 男 2 女 0 未知

    private String province; // 用户个人资料填写的省份

    private String city; // 普通用户个人资料填写的城市

    private String country; // 国家，如中国为CN

    private String headimgurl; // 用户头像

    private String privilege; // 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）

    private String unionid; // 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。


}
