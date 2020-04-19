package com.youaodu.template.common.framework.exception;

import com.youaodu.template.common.framework.http.ResultCode;
import com.youaodu.template.common.framework.http.ResultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * 防止重复命名, 所以这里的名字是以我的名字命名的.
 * 这里拦截了部分异常
 * * @create 2019-08-10 03:41
 */
public class YouaoduExceptionHandler {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(YouaoduExceptionHandler.class);

    /**
     * 统一处理业务错误 >>> 防止报400
     * * @time 03:48
     * @params
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResultMessage businessException(BusinessException e) {
        logger.error("拦截业务异常 >>> {}", e);
        return ResultMessage.error(e.getMessage());
    }

    /**
     * 处理校验参数
     * * @time 22:39
     * @params e
     */
    @ExceptionHandler(value = BindException.class)
    public ResultMessage bindException(BindException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            sb.append(fieldError.getDefaultMessage() + "  ");
        }

        logger.error("参数校验错误 >>> {}", sb.toString());
        return ResultMessage.error(sb.toString());
    }

    /**
     * 处理校验参数
     * * @time 22:39
     * @params e
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultMessage methodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            sb.append(fieldError.getDefaultMessage() + "  ");
        }

        logger.error("参数校验错误 >>> {}", sb.toString());
        return ResultMessage.error(sb.toString());
    }

    @ExceptionHandler(value = TokenException.class)
    public ResultMessage tokenException(TokenException e) {
        return ResultMessage.error(ResultCode.NO_PERMISS);
    }


    @ExceptionHandler(value = Exception.class)
    public ResultMessage Exception(Exception e) {
        logger.error("出现未知异常 >>> {}", e);
        return ResultMessage.error(ResultCode.ERROE);
    }

    /**
     * 请求体为空
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResultMessage httpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResultMessage.error(ResultCode.NO_PARAM);
    }

    /**
     * 请求方式错误
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResultMessage httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return ResultMessage.error(ResultCode.REQUEST_ERROR);
    }
}
