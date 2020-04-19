package com.youaodu.template.common.framework.exception;

/**
 * * @create 2019-08-10 03:36
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(ExceptionMessageEnum message) {
        super(message.getMessage());
    }

}
