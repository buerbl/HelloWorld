package com.test.泛型;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author boolean
 * Date: 2019/6/28 17:18
 * description:
 */
public class normalTest {
    /**
     * 结果是相同的 说明泛型只在编译阶段起作用 编译之后作用失效
     */
    @Test
    public void test(){
        List<String> listString =  new LinkedList<>();
        List<Integer> listInteger = new LinkedList<>();
        String simpleName = listString.getClass().getSimpleName();
        String listInteger1 = listInteger.getClass().getSimpleName();
        if (simpleName.equals(listInteger1)){
            System.out.println("是相同的");
        }

     }

}
