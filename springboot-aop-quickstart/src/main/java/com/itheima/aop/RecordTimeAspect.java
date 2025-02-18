package com.itheima.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect
public class RecordTimeAspect{
    @Around("execution(* com.itheima.service.impl.*.*(..))")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable  {
        long begin= System.currentTimeMillis();

        Object result= pjp.proceed();
        long end=System.currentTimeMillis();
        log.info("方法{}执行耗时 {}ms：",pjp.getSignature(),(end-begin));
        return result;
    }
}
