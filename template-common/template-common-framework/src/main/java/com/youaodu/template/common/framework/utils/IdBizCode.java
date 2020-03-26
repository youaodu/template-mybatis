package com.youaodu.template.common.framework.utils;

public enum IdBizCode {
    ACCOUNT_ID(11, "accountId"),
    USER_ID(12, "userId"),
    ORDER_ID(13, "orderId"),
    REFUND_ID(14, "refundId"),
    ADMIN_ACCOUNT_ID(15, "adminAccountId")
    ;

    IdBizCode(Integer codeNum, String desc) {
        this.codeNum = codeNum;
        this.desc = desc;
    }

    private Integer codeNum;
    private String desc;


    public Integer getCodeNum() {
        return codeNum;
    }

    public String getDesc() {
        return desc;
    }
}
