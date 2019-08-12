package com.demoMuty.helloRS;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.ClassClassPath;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@Aspect
public class aspect {
    private Long startTime;

    /**
     * public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
     */
    @Pointcut("execution (* com.demoMuty.helloRS.controller.*.*(..))")
    private void method(){}

    @Around("method()")
    public void befor( JoinPoint joinPoint) throws Exception{
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature) joinPoint
                .getSignature()).getParameterNames();

        for(int i=0;i<paramNames.length;i++){
            System.out.println(paramNames[i]+","+paramValues[i]);
            paramValues[i] = "13";
        }


    }
//
//    @AfterReturning("method()")
//    public void after(){
////        Long endTime = System.currentTimeMillis();
////        Long costTime = endTime - startTime;
////        System.out.println("point_1:"+costTime+"");
//        log.info("后的调用");
//    }


}
