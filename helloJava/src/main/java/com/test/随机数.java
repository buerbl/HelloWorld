package com.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author buer
 * @create 2019/5/7 23:19
 * @description
 */
public class 随机数 {
    @Test
    public void test(){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            int j = (int) (Math.random()*4);

            list.add(j);

        }
        System.out.println(Arrays.toString(new List[]{list}));

    }
}
