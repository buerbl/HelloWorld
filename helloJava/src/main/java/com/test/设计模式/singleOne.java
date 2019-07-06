package com.test.设计模式;

/**
 * @author boolean
 * Date: 2019/6/27 10:25
 * description: 单例模式 静态模式 饿汉式 直接加载
 */
public class singleOne {


    private static singleOne instance = new singleOne();

    public static singleOne getInstance(){
        return instance;
    }

    private singleOne(){

    }
}
