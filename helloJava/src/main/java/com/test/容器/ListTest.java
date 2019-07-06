package com.test.容器;

import org.junit.Test;

import java.util.*;

/**
 * @author boolean
 * Date: 2019/5/28 15:27
 * description:
 */
public class ListTest {
    @Test
    public void test(){
        List<Integer> aList = new LinkedList();
        for (int i = 0; i < 10; i ++){
            int num = new Random().nextInt(10);
            aList.add(num);
        }

        for (Integer i : aList){
            System.out.println(i);
        }
        aList.forEach(System.out::println);
        for (int i = 0; i < 10; i++){
            System.out.println(aList.get(i));
        }

        aList.forEach(System.out::println);
    }
}
