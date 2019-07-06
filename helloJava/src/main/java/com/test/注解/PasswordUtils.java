package com.test.注解;

import org.junit.Test;

/**
 * @Author buer
 * @create 2019/5/9 23:43
 * @description
 */
public class PasswordUtils {
    @UseCase(id = 47, description = "ss")
    public boolean validatePassword(String password){
        return (password.matches("\\w*\\dw*"));

    }

    @Test
    public void  test(){
        validatePassword("s");
    }
}
