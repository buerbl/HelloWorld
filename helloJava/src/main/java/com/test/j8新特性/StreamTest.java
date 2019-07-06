package com.test.j8新特性;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: boolean
 * @Date: 2019/5/17 9:34
 * @description: Stream新特实践 实践 实践
 */
public class StreamTest {
    @Test
    public void test1(){
        //通过集合创建Stream  asList()->返回由指定数组支持的固定大小的列表
        List<String> str = Arrays.asList("A", "HasmMapTest", "c");
        Stream<String> stringStream = str.stream();
        System.out.println(stringStream);
    }
}
