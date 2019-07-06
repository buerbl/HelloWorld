package com.test.多线程;

import org.junit.Test;

/**
 * @author buer
 * create 2019/5/19 11:59
 * description  i++在
 */
public class I {
    int a = 0;
    private volatile static int i = 0;
    @Test
    public void test() throws InterruptedException{




            Thread a = new Thread(()-> {
                    for( int j = 0 ; j < 1000000 ; j++ ) i++;
            });
            a.start();
            a.join();
//            Thread HasmMapTest = new Thread() {
//                @Override
//                public void run() {
//                    for( int j = 0 ; j < 1000000 ; j++ ) i--;
//                }
//            };
//            HasmMapTest.start();
//            a.join();
//            HasmMapTest.join();
            System.out.println(i);



    }

    @Test
    public void test1() throws InterruptedException {
        for (int i = 0; i < 10; i ++){
            test();
        }
    }



}
