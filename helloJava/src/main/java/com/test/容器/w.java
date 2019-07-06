package com.test.容器;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;

/**
 * @author buer
 * create 2019/5/18 22:15
 * description
 */
public class w {

    @Test
    public  void test(){
        int a = 10;
        o(a);
        System.out.println(a);
        String name = null;
        StringUtils.isNotBlank(name);
    }

    private void o(int a) {
        System.out.println(a);
        System.out.println(1);
    }


}
