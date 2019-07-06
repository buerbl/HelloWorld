package com.test.枚举类的使用;

import org.junit.Test;

/**
 * @author boolean
 * Date: 2019/6/10 19:44
 * description:
 */
public class a {

    @Test
    public  void test(){
        System.out.println("sasa");
    }

    @Test
    public void test1(){
        System.out.println(Color.getName(1));
        System.out.println(Color.getIndex("红色1"));
    }
}
