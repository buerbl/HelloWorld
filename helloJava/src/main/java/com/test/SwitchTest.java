package com.test;

import org.junit.Test;

/**
 * @author boolean
 * Date: 2019/5/28 15:15
 * description: case的return和break
 */
public class SwitchTest {

    @Test
    public void test(){
        int i = 0;
        switch (i){
            case 0:

                System.out.println(1);
                return;  //return之后不能再写语句

        }
    }
}
