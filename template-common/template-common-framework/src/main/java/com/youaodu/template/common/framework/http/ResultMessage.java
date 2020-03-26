package com.youaodu.template.common.framework.http;

/**
 * * @create 2019-08-10 03:13
 */
public class ResultMessage<T> {
    private Integer state;
    private String message;
    private T data;

    public static ResultMessage ok() {
        ResultCode resultCode = ResultCode.SUCCESS;
        // 最后返回结果
        ResultMessage result = new ResultMessage<>();
        result.state = resultCode.getState();
        result.message = resultCode.getMessage();
        return result;
    }

    public static ResultMessage ok(String message) {
        ResultCode resultCode = ResultCode.SUCCESS;
        ResultMessage result = new ResultMessage();
        result.state = resultCode.getState();
        result.setMessage(message);
        return result;
    }

    public static <T> ResultMessage ok(T data) {
        ResultCode resultCode = ResultCode.SUCCESS;
        // 最后返回结果
        ResultMessage<T> result = new ResultMessage<>();
        result.state = resultCode.getState();
        result.message = resultCode.getMessage();
        result.setData(data);
        return result;
    }

    public static <T> ResultMessage ok(T data, String message) {
        // 最后返回结果
        ResultMessage<T> result = new ResultMessage<>();
        result.state = 200;
        result.message = message;
        result.setData(data);
        return result;
    }

    public static <T> ResultMessage ok(T data, ResultCode resultCode) {
        // 最后返回结果
        ResultMessage<T> result = new ResultMessage<>();
        result.state = resultCode.getState();
        result.message = resultCode.getMessage();
        result.setData(data);
        return result;
    }

    public static ResultMessage error(ResultCode resultCode) {
        ResultMessage result = new ResultMessage();
        result.state = resultCode.getState();
        result.message = resultCode.getMessage();
        return result;
    }

    public static ResultMessage error(String message) {
        // 最后返回结果
        ResultMessage result = new ResultMessage();
        result.state = 500;
        result.message = message;
        return result;
    }

    public Integer getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
