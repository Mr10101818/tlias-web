package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
@Order(1)
public class MyAspect4 {
    //前置通知
    @Before("execution(*  com.itheima.service.*.*(..))")
    public void before(JoinPoint joinPoint){
        log.info("MyAspect4 -> before ...");
        Object target= joinPoint.getTarget();
        log.info("MyAspect4 -> target:{}",target);
        String classname= joinPoint.getTarget().getClass().getName();
        log.info("MyAspect4 -> classname:{}",classname);
        String methodName= joinPoint.getSignature().getName();
        log.info("MyAspect4 -> methodName:{}",methodName);
        Object[] args= joinPoint.getArgs();
        log.info("MyAspect4 -> arg:{}", Arrays.toString(args));

    }

    //后置通知
    @After("execution(* com.itheima.service.impl..*(..))")
    public void after(){
        log.info("MyAspect4 -> after ...");
    }
}
