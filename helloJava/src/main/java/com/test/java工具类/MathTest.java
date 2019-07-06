package com.test.java工具类;

import org.junit.Test;

import java.util.Random;

/**
 * @author boolean
 * Date: 2019/5/24 11:09
 * description:
 */
public class MathTest {
    @Test
    public void test(){
        for (int i = 0; i < 100; i ++){
            int j = 100;
            System.out.println(new Random().nextInt(j));
        }

    }
}
