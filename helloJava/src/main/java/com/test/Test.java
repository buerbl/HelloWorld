package com.test;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: boolean
 * @Date: 2019/4/15 14:42
 */
public class Test {
    @org.junit.Test
    public void test(){
        Assert.assertEquals(1,1);
    }

    public void tesdt(int a){
        System.out.println(a);
    }

    @org.junit.Test
    public  void test2(){
        Integer a= null;
        tesdt(a);
    }
}
