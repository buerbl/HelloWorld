package com.test;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;


/**
 * @Author: boolean
 * @Date: 2019/4/20 16:27
 * @description:
 */

public class dataTest {
    @Test
    public void test(){
        System.out.printf("撒");
        System.out.println(new Date());
    }

    @Setter
    @Getter
    class User1{
        private int id;
        private String name;
        private String password;
    }

    @Setter
    @Getter
    class  User2{
        private int id;
        private String name;

    }

    @Test
    public void converted(){
        User1 user1 = new User1();
        User2 user2 = new User2();
        user1.setId(1);
//        user1 = user2;
//        System.out.println(user1.getClass().getName());
        System.out.println(UUID.randomUUID().toString());
    }



}
