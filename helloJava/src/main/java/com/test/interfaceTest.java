package com.test;

import org.junit.Test;

import javax.annotation.Resource;

/**
 * @Auther: boolean
 * @Date: 2019/4/19 00:26
 * @Description:
 */
public interface interfaceTest {
    void a();
    void b();
    void c();
}

class Chilren implements interfaceTest{

    @Override
    public void a() {
        System.out.println(1111);
    }

    @Override
    public void b() {

    }

    @Override
    public void c() {

    }

    @Resource
    private interfaceTest aa;


    @Test
    private void a1(){
         aa.a();
    }

    @Test
    void aaa(){

    }
}


