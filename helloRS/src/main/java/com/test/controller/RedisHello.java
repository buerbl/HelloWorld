package com.test.controller;

import com.test.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.soap.SAAJResult;

/**
 * @author boolean
 * Date: 2019/7/2 19:48
 * description:
 */
@RestController
@RequestMapping("/helloRS/redisHello")
public class RedisHello {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/hello")
    public String  hello(){
        LogUtil.info("redis的展示：[{}]", redisTemplate);
        return "hello, redis";
    }

    @RequestMapping("/cache")
    public String cache(){

        return "hello, cache";
    }
}
