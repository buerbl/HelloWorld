package com.test.classtest;

import org.junit.Test;

/**
 * @Author buer
 * @create 2019/4/28 10:05
 * @description
 */
public class Classtest {
    @Test
    public void defaultTest(){
        Animal animal  = new Animal();
        System.out.println(animal.name);
    }


    @Test
    public void equalTestByObject(){
        Dog dog = new Dog();
        Animal animal = new Animal();
        dog = (Dog) animal;
        //父类级别高，类比数据类型装换
        animal = dog;
//        System.out.println(animal);
        int a = 1;
        double b =  1.1;
        b = a;
        //返回对象 Double.valueOf()

    }



}
