package com.test.lambdatest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author boolean
 * Date: 2019/7/1 16:13
 * description:
 */
public class PersonService {

    /**对
     * @see Person
     * 的属性年龄排序
     * lambda实现
     */
    @Test
    public void testObjectSort() {
        List<Person> list = new ArrayList<>();

        list.add(new Person("三炮", convert("2019-05-10")));
        list.add(new Person("老王", convert("2019-05-11")));
        list.add(new Person("小明", convert("2019-05-12")));
        list.add(new Person("叫兽", convert("2019-05-09")));
        System.out.println(list);
        //按年龄升序
        list.sort((a, b) -> a.getAge().compareTo(b.getAge()));
        System.out.println(list);
        //按年龄降序
        list.sort((a, b) -> b.getAge().compareTo(a.getAge()));
        System.out.println(list);
    }

    private Date convert(String time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    @Test
    public void test1(){
        Date a = convert("2010-01-011");
        System.out.println(a);
        Date b = convert("2010-01-0");
        System.out.println(b);
        System.out.println(a==b);
        System.out.println();
        int compareTo = a.compareTo(b);
        System.out.println(compareTo);
    }
}
