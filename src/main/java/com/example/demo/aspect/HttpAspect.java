package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by baoyu on 2018/9/11.
 * AOP--Http统一处理
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 定义一个公共的切面方法
     */
    @Pointcut("execution(public * com.example..demo.controller.Controller_json.*(..))")
    public void doing(){

    }

//    /**
//     * 普通aop拦截方法.
//     */
//    @Before("execution(public * com.example.demo.controller.Controller_json.findAllUsers(..))")
//    public void findAllUsers(){
//        logger.warn("findAllUsers.....");
//    }

    /**
     * 调用公共的切面方法。
     */
    @After("doing()")
    public void checkAllActions(){
        logger.info("check All Action...");
    }

    /**
     * 记录所有HTTP请求信息
     */
    @Before("doing()")
    public void recordHttpRequest(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = attributes.getRequest();
        //url
        logger.info("url={}",httpServletRequest.getRequestURI());
        //method
        logger.info("method={}",httpServletRequest.getMethod());
        //ip
        logger.info("ip={}",httpServletRequest.getRemoteAddr());
        //请求类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //请求参数
        logger.info("args={}",joinPoint.getArgs());
    }

    /**
     * 获取http请求返回结果信息
     */
    @AfterReturning(returning = "object",pointcut = "doing()")
    public void recordHttpResponse(Object object){
        logger.info("response={}",object.toString());
    }

}
