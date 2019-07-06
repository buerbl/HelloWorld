package com.test.classtest;

import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author buer
 * @create 2019/4/28 10:06
 * @description test
 */

public class Dog extends Animal {
    private  String dogid;

    @Override
    public String toString() {
        return "Dog{" +
                "dogid='" + dogid + '\'' +
                ", name='" + name + '\'' +
                ", parent='" + parent + '\'' +
                ", test='" + test + '\'' +
                '}';
    }

    //使用父类属性
    @Test
    public void useTest(){
//        Animal animal = new Animal();
//        System.out.println(animal);
    }

     @Test
//    @Override
    public void get1Id() {
         //super关键字
          int a = super.getId();
         Assert.assertEquals(a,1);
//         System.out.println(A);
    }
    @Test
    //使用父方法
    public void method() {
//        Dog dog = new Dog();
//        dog.eat();
    }

    /**
     * 子类赋值给父类 b不行  大到小了
     *就像抽象类被子类是实例化
     */
    @Test
    public void test(){
        Animal animal = new Animal();
        Dog dog = new Dog();
        dog.setDogid("1");
//        dog = animal;
        test1(dog);
    }

    public void test1(Animal animal){
        System.out.println("变化");
        //anmial变成了dog类  卧槽卧槽卧槽
        System.out.println(animal.getClass());
        System.out.println(animal.toString());
    }


    @Test
    public void test2(){
        Dog dog = new Dog();
        dog.setDogid("1");
        System.out.println("前："+dog.toString());
        setValue(dog);
        System.out.println("后： "+dog.toString());
    }


    @Test
    public void testFather(){
        Dog dog = new Dog();
        System.out.println(dog.name);
    }

    public Dog setValue(Dog dog1){
        dog1.setDogid("2");
        return dog1;
    }

    public String getDogid() {
        return dogid;
    }

    public void setDogid(String dogid1) {
        this.dogid = dogid1;
    }
}
