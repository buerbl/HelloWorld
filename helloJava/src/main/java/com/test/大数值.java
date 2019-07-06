package com.test;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @Author buer
 * @create 2019/5/7 23:04
 * @description 1、BigInteger 2、BigDecimal
 */
public class 大数值 {
    @Test
    public void test(){
        int a = 100;
        BigInteger bigInteger1 = BigInteger.valueOf(100);
        BigInteger bigInteger2 = BigInteger.valueOf(200);
        System.out.println("大数值之整形：" + bigInteger1);
        BigInteger c = bigInteger1.add(bigInteger2);
        System.out.println("相加：" + c);
        BigInteger e = bigInteger1.multiply(bigInteger2);
        System.out.println("相乘：" + e);

    }
}

