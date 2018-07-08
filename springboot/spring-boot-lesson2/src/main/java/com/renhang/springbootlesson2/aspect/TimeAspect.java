package com.renhang.springbootlesson2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author heng.jia
 * @date 2018/6/29 下午12:01
 */
@Aspect
@Component
public class TimeAspect {
    @Around("execution(* com.renhang.springbootlesson2.controller.UserController.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("time aspcet start");
        Object[] args = pjp.getArgs();
        for(Object arg : args){
            System.out.println("arg is " + arg);
        }
        long start = new Date().getTime();
        Object object = pjp.proceed();
        System.out.println("time aspect 耗时：" + (new Date().getTime() - start));
        System.out.println("time aspect end");

        return object;
    }
}
