package com.test;

/**
 * @Author: boolean
 * @Date: 2019/4/15 14:40
 * 链式调用 只有返回调用对象即可
 */
public class SetTest {
    public class User{
        private String username;
        private String password;
        private String sex;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
//            return this;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
//            return this;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }


    @org.junit.Test
    public void set(){
        User u  = new User();
//        u.setUsername("usename")
        System.out.println(u.toString());
    }

}
