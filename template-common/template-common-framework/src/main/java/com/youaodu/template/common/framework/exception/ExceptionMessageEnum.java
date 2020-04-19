package com.youaodu.template.common.framework.exception;

public enum ExceptionMessageEnum {
    PARAM_NULL("参数不能为空"),
    ERROR("系统异常"),
    ACCOUNT_IS_EXISTS("账号已存在"),
    ACCOUNT_IS_NOT_EXISTS("账号不存在，请前往注册"),
    VERIFY_CODE_EXPIRE("验证码已过期，请重新获取"),
    VERIFY_CODE_ERROR("短信验证码输入错误")
    ;

    ExceptionMessageEnum(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
