package com.demoMuty.core.aopUtils;

import com.demoMuty.core.entity.DTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * 打日记的切面
 */
@Slf4j
@Component
@Aspect
public class LogAop {
    @Pointcut(value = "execution(* com.demoMuty.core.controller.*.*(..))")
    public void method(){
    }

    @Around("method()")
    public Object  before(ProceedingJoinPoint point){
        Object[] args = point.getArgs();
        args.getClass().getName();
        Field[] fieldInfo = args.getClass().getDeclaredFields();
        for (int i = 0; i < fieldInfo.length; i ++) {
            fieldInfo[i].setAccessible(true); //成员变量为private,故必须进行此操
            log.info("fiels的值[{}]", fieldInfo[i]);
        }
        log.info("before的值[{}]", System.currentTimeMillis());
//        args[0] ="2";
//        DTO dto = args;
        for (int i = 0; i < args.length; i++) {
            log.info("参数[{}]", args[i]);
            log.info("名称[{}]", point.getTarget());
        }
        try {
            point.proceed(args);
//            args[0] = "change";
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return args[0].toString();
    }

    @After("method()")
    public void after(){
        log.info("after的值[{}]", System.currentTimeMillis());
    }

}
