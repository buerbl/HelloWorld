package com.test.j8新特性;

import org.junit.Test;

import java.util.Optional;

/**
 * @Auther: boolean
 * @Date: 2019/4/14 23:38
 * @Description:
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> strOpt = Optional.of("Hello World");
        strOpt.ifPresent(System.out::println);
    }

    public class User{
        public String name = null;

        public void setName(String name) {
            this.name = name;
        }

    public String getName() {
        return name;
    }
}


    public  String getName1() {
        /**
         * user为空则赋值Unknown 否则赋值为user.name
         */
        User u = new User();
        //new
        return Optional.ofNullable(u)
                .map(user -> user.name)
                .orElse("Unknown");


        //old
//        if (u == null){
//            u.setName("Unknown") ;
//        }else {
//
//        }
//        System.out.println(u.getName());
//        return u.toString();
    }

    @Test
    public void test(){
        String re =  getName1();
        System.out.println(re.toString()+"11111111111111111111111");

    }

}
