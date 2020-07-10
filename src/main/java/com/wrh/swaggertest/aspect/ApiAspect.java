package com.wrh.swaggertest.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * API 接口切面
 * 所属公司: 华信联创技术工程有限公司
 * 版本: 1.0
 * 创建人: 徐延
 * 创建时间: 2019-04-09 10:46:01
 */
@Slf4j
@Aspect
@Order(1)
@Component
public class ApiAspect {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Pointcut("execution(public * com.wrh.swaggertest.action..*.*(..))")
    public void api() {
    }

    @Around("api()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {

        // 接收到请求，打印请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + proceedingJoinPoint.getSignature().getDeclaringTypeName() + "."
                + proceedingJoinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(proceedingJoinPoint.getArgs()));

        Object result = null;
        Throwable error = null;
        MyException myException = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (MyException e) {
            error = e;
            myException = e;
        } catch (Throwable e) {
            error = e;
            // 打印出错记录
            log.error(request.getRequestURL().toString(), e);
        }

        // 处理出错
        if (error != null) {
            if (myException != null) {
                result = new ResponseData(myException.getCode(), myException.getMsg(), null);
            } else {
                result = ResponseData.error();
            }
        }

        if (result instanceof ResponseData) {
            // 处理完请求，打印返回内容
            log.info("RESPONSE : [" + ((ResponseData) result).getCode() + ", " + ((ResponseData) result).getMsg() +
                    "]");
        }
        response.addHeader("Cache-Control", "no-cache");
        return result;
    }
}
