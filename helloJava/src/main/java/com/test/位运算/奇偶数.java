package com.test.位运算;

import org.junit.Test;

/**
 * @author boolean
 * Date: 2019/5/17 21:01
 * description:
 */
public class 奇偶数 {
    @Test
    public void odd(){
        for (int i = 0; i <=100; i ++){
            int n = (int) (Math.random()*100);

            if ((n & 1) == 1){
                System.out.println(n+"：我是奇数");
            }
            if ((n & 1) == 0){
                System.out.println(n+"：我是偶数");
            }
        }


    }
}
