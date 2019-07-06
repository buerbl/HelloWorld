package com.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author buer
 * @create 2019/5/2 0:27
 * @description
 */
public class Fanshe {
    //门面模式
    private static  final Logger log = LoggerFactory.getLogger(Fanshe.class);

    @Test
    public void test(){
        Fanshe fanshe = new Fanshe();
//        System.out.println(
               String a =  fanshe.getClass().getName().replace("F", "1");
//        );
//        Logger.getLogger(String.valueOf(Fanshe.class)).info(fanshe.getClass().getName().replace("F", "1  "));
        log.info("a的值："+a);
    }
}
