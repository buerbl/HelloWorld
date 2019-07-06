package com.test.操作符;

import org.junit.Test;
import org.junit.runner.notification.RunListener;

/**
 * @Author: boolean
 * @Date: 2019/5/7 9:36
 * @description:
 * 1、按位与 “&”
 * 2、按位或“|”
 * 3、按位异或" ^ ”
 */
public class 位运算符 {

    //按位与操作符
    @Test
    public void yu(){
        System.out.println(11&01);
    }
    //按位或操作符
    @Test
    public void huo(){
        System.out.println("1|0: "+(1|0));
        System.out.println( "1|1: "+(1|1));
        System.out.println("11|10: "+(11| 10));
        System.out.println("11|11: "+(11|11));
        System.out.println("111|1: "+(101|1));
    }

    @Test
    public void yihuo(){
        System.out.println("1^0: "+(1^0));
        System.out.println("1^1: "+(1^1));
        System.out.println("0^0: "+ (0^0));
    }


}
