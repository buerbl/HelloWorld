package com.demoMuty.core.aopUtils;

import com.demoMuty.core.entity.DTO;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

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

    @Before("method()")
    public void   before(JoinPoint point) {
        Object[] arg = point.getArgs();
        log.info("arg的字段值：[{}]", Arrays.toString(arg));
        log.info("before的值[{}]", System.currentTimeMillis());
        log.info("arg的值[{}]", arg[0]);
        Field[] declaredFields = arg[0].getClass().getDeclaredFields();
        log.info("字段值：[{}]", Arrays.toString(declaredFields));
        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            String name1 = declaredFields[i].getName();
            log.info("获取的参数[{}]" ,name1);
            try {
                Object name = declaredFields[i].get(arg[0]);
                log.info("获取的参数值[{}]" ,name);
                declaredFields[i].set(arg[0], "1");
                Object o = declaredFields[i].get(arg[0]);
                log.info("获取修改后的参数值[{}]" ,o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


    }

    @After("method()")
    public void after(){
        log.info("after的值[{}]", System.currentTimeMillis());
    }

}
