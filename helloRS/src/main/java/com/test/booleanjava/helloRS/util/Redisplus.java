package com.test.booleanjava.helloRS.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author boolean
 * Date: 2019/7/2 19:48
 * description:
 */

//@Component

//@Configuration



@Component
public class Redisplus {

    @Autowired
    private  RedisTemplate redisTemplate;

//    @Bean
//    public RedisTemplate getredisTemplate(){
//        return redisTemplate = new RedisTemplate();
//    }



//    @Bean
    public  void set(String key, String value){
        redisTemplate.opsForValue().set(key, value);

    }
}