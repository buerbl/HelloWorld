package com.test.力扣;

import org.junit.Test;

/**
 * @author boolean
 * Date: 2019/6/11 20:26
 * description:
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2 (31),  2 (31) − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 规律：a*10+b
 */
public class Integerinversion {
    public int reverse(int x) {

        int tem = x;
        int res = 0;
        while(tem > 0){
            res =+(tem % 10) * 10;
            System.out.println(res);
            tem = tem/10;
            System.out.println(tem);
        }
        return 1;

    }
    @Test
    public void test(){

        System.out.println(Integer.MIN_VALUE-1);
    }
}
