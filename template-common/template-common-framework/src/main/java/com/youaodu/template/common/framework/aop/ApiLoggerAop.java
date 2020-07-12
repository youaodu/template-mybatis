package com.youaodu.template.common.framework.aop;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.youaodu.template.common.framework.annotation.ApiLog;
import com.youaodu.template.common.framework.config.entity.ApiLogger;
import com.youaodu.template.common.framework.config.mapper.ApiLoggerMapper;
import com.youaodu.template.common.framework.token.BuilderToken;
import com.youaodu.template.common.framework.token.Token;
import com.youaodu.template.common.framework.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class ApiLoggerAop {

    @Autowired
    private ApiLoggerMapper apiLoggerMapper;

    @Pointcut("@annotation(com.youaodu.template.common.framework.annotation.ApiLog)")
    public void logAspect() {
    }


    @Before("logAspect()&&@annotation(apiLog)")
    public void logAspectBefore(JoinPoint joinPoint, ApiLog apiLog) {
        log.info("接口日志记录 >>>>>>>>>  {}", DateUtil.date());
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest();
        String params = JSONUtil.toJsonStr(joinPoint.getArgs());
        ApiLogger apiLogger = new ApiLogger();
        apiLogger.setParams(params);
        apiLogger.setMethod(request.getMethod());
        apiLogger.setApiPath(request.getServletPath());
        apiLogger.setIpAddress(IpUtil.getIpAddr(request));
        apiLogger.setApiDescr(apiLog.desc());
        String tokenStr = request.getHeader("Token");
        if (StrUtil.isNotBlank(tokenStr)) {
            Token token = BuilderToken.analysisToken(tokenStr);
            apiLogger.setAccountName(token.getAccountName());
            apiLogger.setAccountId(token.getAccountId());
        }
        apiLoggerMapper.insert(apiLogger);
    }

}
