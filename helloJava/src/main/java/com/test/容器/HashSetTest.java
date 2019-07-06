package com.test.容器;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author buer
 * create 2019/6/9 22:23
 * description HashSet的去重
 */
public class HashSetTest {
    private final static Logger logger = LoggerFactory.getLogger(HashSetTest.class);

    @Test
    public void test() {
        Set<String> set = new HashSet<>();
        List<String> list = new LinkedList<>();
        list.add("s");
        list.add("s");
        list.add("z");
        System.out.println("==============list的值===================");
        list.forEach(System.out::println);
        List<String> list1 = new LinkedList<>();
        for (String a : list){
            if (!set.add(a)){
                list1.add(a);
            }

        }
        System.out.println("==============set不重复===================");
        set.forEach(System.out::println);
        System.out.println("==============set的foreach===================");
        for (String a : set){
            System.out.println(a);
        }

//        for (String a : list){
//            if (set.contains(a)){
//                list1.add(a);
//            }
//        }

        System.out.println("==============找出重复的list1===================");
        list1.forEach(System.out::println);
    }

//    ThreadPoolExecutor

    @Test
    public void test1(){
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);
    }
}
