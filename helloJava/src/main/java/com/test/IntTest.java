package com.test;

import org.junit.Test;

/**
 * @author boolean
 * Date: 2019/5/29 9:54
 * description: 测试idea的反编译
 */
public class IntTest {
    @Test
    public void test(){
        int i = 1;
        Integer n = i;
        System.out.println(n);
    }
}
