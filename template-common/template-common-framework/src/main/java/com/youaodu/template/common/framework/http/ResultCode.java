package com.youaodu.template.common.framework.http;

/**
 * * @create 2019-08-10 03:16
 */
public enum ResultCode {

    SUCCESS("执行成功", 200),
    NO_PERMISS("Token失效", 401),
    ERROE("系统开小差", 500),
    NO_TOKEN("没有token", 402),
    NO_PARAM("参数不能为空", 500),
    REQUEST_ERROR("请求错误, 请求更换请求方式", 500)
    ;

    private String message;
    private Integer state;

    ResultCode(String message, int state) {
        this.message = message;
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
