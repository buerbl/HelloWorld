package com.test.classtest;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

/**
 * @Author buer
 * @create 2019/4/28 10:06
 * @description 父类
 */

 public class Animal {
    private int id;
    String name="chen";
    protected String parent="chen";
    public String test="chen";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Test
    public void eat(){

        Animal animal  = new Animal();
        System.out.println(animal.name);
    }
}
