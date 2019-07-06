package com.test.位运算;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author boolean
 * Date: 2019/5/29 9:56
 * description:
 */
public class 乘除 {

    private int i = 1;
    private int times = 100000000;
    private static final Logger logger = LoggerFactory.getLogger(乘除.class);


    /**
     * 测试平常运算的时间
     */
    @Test
    public void test(){
        long start2 = System.currentTimeMillis();
        logger.debug("s2时间为【{}】",start2);
//        logger.info("s2时间为【{}】",start2);

        for (int j = 0; j < times; j ++){
            int result1 = i * 8;
        }
        System.out.println("平常花费时间：" + (System.currentTimeMillis() - start2) );
    }

    /**
     * 测试位运算的时间
     */
    @Test
    public void test1(){
        long start1 = System.currentTimeMillis();
        logger.debug("s2时间为【{}】",start1);
        for (int j = 0; j < times; j ++){
            int result2 = i << 3;
        }
        System.out.println("左移花费时间：" + (System.currentTimeMillis() - start1) );
    }

    @Test
    public void test2(){
            test();
            test1();


    }
}
