package com.test.容器;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author buer
 * @create 2019/5/18 22:15
 * @description
 */
public class HasmMapTest {
    private final static Logger logger = LoggerFactory.getLogger(HasmMapTest.class);
    //hashmap的初始值对性能影响
    public int test( int true1,   int false1){
        int aHundredMillion = 100;
        int times = 100;


        Map<Integer, Integer> map = new HashMap<>();

        long s1 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            map.put(i, i);
        }
        new Date();
        long s2 = System.currentTimeMillis();

        System.out.println("未初始化容量，耗时 ： " + (s2 - s1));


        Map<Integer, Integer> map1 = new HashMap<>(aHundredMillion);

        long s5 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            map1.put(i, i);
        }
        long s6 = System.currentTimeMillis();

        System.out.println("初始化容量16，耗时 ： " + (s6 - s5));
        System.out.println((s2 - s1) >= (s6 - s5));

        if ((s2 - s1) >= (s6 - s5)){
            true1 = true1+1;

        }else {
            false1++;
        }
        return true1;


//
//        Map<Integer, Integer> map2 = new HashMap<>(aHundredMillion);
//
//        long s3 = System.currentTimeMillis();
//        for (int i = 0; i < times; i++) {
//            map2.put(i, i);
//        }
//        long s4 = System.currentTimeMillis();
//
//        System.out.println("初始化容量为10000000，耗时 ： " + (s4 - s3));
    }

    @Test
    public void test1(){
        int true1=0;
        int false1=0;
        int times = 0;

        for (int i = 0; i < 1000; i ++){
            times = test(true1, false1);
        }
        System.out.println("true次数："+times);
//        System.out.println(false1);

    }






}
