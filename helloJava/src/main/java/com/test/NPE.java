package com.test;

import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Collections;
import java.util.Objects;

/**
 * @Author buer
 * @create 2019/5/15 22:24
 * @description
 */
public class NPE {
    private String name;
    private int a;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NPE npe = (NPE) o;
        return Objects.equals(name, npe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    @Test
    public  void  test1(){
        if (name != null ){
            System.out.println(name);
        }else {
            System.out.println("q");
        }


    }

    @Test
    public void test(){
        String name;
        name =null;

        if (StringUtils.isNotEmpty(name)) {
            name.toString();
        }
        System.out.println(1);
    }

    //返回空集合
    @Test
    public void testEmptyList(){
        System.out.println(Collections.emptyList());
        System.out.println(new Gson().toJson(Collections.emptyList()));
        String a = "chen";
        int b = 1;


        System.out.println(new Gson().toJson(a));
        System.out.println(new Gson().toJson(b));
    }


}
