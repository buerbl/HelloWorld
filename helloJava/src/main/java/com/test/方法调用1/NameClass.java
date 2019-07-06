package com.test.方法调用1;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

/**
 * @author boolean
 * Date: 2019/5/28 17:07
 * description:
 */

public class NameClass {
    private String name = "chen";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void test1(NameClass nameClass){
        nameClass.setName("chenwen");
    }

    @Test
    public void test(){
        NameClass nameClass = new NameClass();
        test1(nameClass);
//        nameClass.name
        System.out.println(nameClass.getName());
    }

}
