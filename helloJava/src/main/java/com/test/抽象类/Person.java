package com.test.抽象类;

/**
 * @Author buer
 * @create 2019/5/17 0:39
 * @description person抽象类
 *
 */
public abstract class Person {
    public abstract String getdDescription();
    private String name;
    //可以有构造器
    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
