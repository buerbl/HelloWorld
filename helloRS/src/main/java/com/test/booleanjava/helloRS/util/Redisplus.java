package com.test.booleanjava.helloRS.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author boolean
 * Date: 2019/7/2 19:48
 * description:
 */

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