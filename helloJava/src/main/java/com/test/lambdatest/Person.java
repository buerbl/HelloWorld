package com.test.lambdatest;

import lombok.Data;

import java.util.Date;

/**
 * @author boolean
 * Date: 2019/7/1 16:11
 * description:
 */
@Data
public class Person {
    private String name;
    private Date age;

    public Person(String name, Date age) {
        this.name = name;
        this.age = age;
    }
}
