package com.test.静态类实践;

import org.junit.Test;

/**
 * @author boolean
 * Date: 2019/5/20 9:44
 * description: static关键字执行顺序
 */
public class StaticTest {

    private static Integer a;
    protected static Integer b;
    public Integer c;
    public static Integer d;


    static{
        System.out.println("test static");
    }

    public StaticTest(){
        System.out.println("test constructor");
    }

    public  void  test1(){

    }

    public  static void  test2(){

    }

    public static void main(String[] args) {
        new StaticTest();
        System.out.println("====================1");
        new StaticTest();
        System.out.println("====================2");
        new StaticTest();

    }


         static class Base{



            static{
                System.out.println("base static");
            }

            public Base(){

                System.out.println("base constructor");
            }

            @Test
            public void test(){
                System.out.println(a);
            }

        }
}

