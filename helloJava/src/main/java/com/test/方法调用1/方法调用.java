package com.test.方法调用1;

import org.junit.Test;

import javax.naming.NameClassPair;

/**
 * @author boolean
 * Date: 2019/5/28 17:01
 * description:
 */
public class 方法调用 {


    public int test2(int a){
        a = a+1;
        return a;
    }

    public String test3(String name){
        name =  name+"wen";
        return name;
    }

    //基本形参调用
    @Test
    public void test2(){
        int i = 1;
        System.out.println(test2(i));;
    }

    //
    @Test
    public void test3(){
        int i = 1;
        test2(i);
        System.out.println(i);
    }

    @Test
    public void test(){
        String name = "chen";
        test3(name);
        System.out.println(name);
    }







}
