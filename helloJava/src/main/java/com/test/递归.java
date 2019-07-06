package com.test;

import org.junit.Test;
import sun.rmi.runtime.Log;
//import sun.rmi.runtime.Log;

/**
 * @Author: boolean
 * @Date: 2019/5/8 9:25
 * @description:
 */
public class 递归 {
    @Test
    public void test(){
        System.out.println(F(10));;

    }

    private int F(int n) {
        if(n==0 || n==1) {
            //递归边界
            return 1;
        }
        //递归公式
        return F(n-1) + F(n-2);



    }
}

