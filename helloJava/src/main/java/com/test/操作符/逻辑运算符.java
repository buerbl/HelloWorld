package com.test.操作符;

import org.junit.Test;

/**
 * @Author: boolean
 * @Date: 2019/5/7 9:22
 * @description:
 */
public class 逻辑运算符 {

    //短路演示
    @Test
    public void shortcutting(){
        boolean  b = test1(0) && test2(2) && test3(2);
        System.out.println("expression is " + b);
    }

    @Test
    public void yu(){
        System.out.println(1| 1);
    }



    private  boolean test3(int i) {
        System.out.println("test1(" + i + ")");
        System.out.println("result:" + (i < 1));
        return i < 1;
    }

    private boolean test2(int i) {
        System.out.println("test2(" + i + ")");
        System.out.println("result:" + (i < 2));
        return i < 3;
    }

    private boolean test1(int i) {
        System.out.println("test3(" + i + ")");
        System.out.println("result:" + (i < 3));
        return i < 3;
    }


}
