package com.test.booleanjava.helloRS.controller;


import com.test.booleanjava.helloRS.entity.User;
import com.test.booleanjava.helloRS.util.Redisplus;
import com.test.booleanjava.helloRS.service.IUserService;
import com.test.booleanjava.helloRS.util.RedisUtil;
import com.test.base.core.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author booleanjava
 * Date: 2019/7/2 19:48
 * description:
 */
@RestController
@RequestMapping("/helloRS/redisHello")
public class RedisHello {
    private final static Logger logger = LoggerFactory.getLogger(RedisHello.class);

    private final static String USERKEY = "com.test.booleanjava.helloRS.controller.setex";
    private final static String LOCKKEY = "com.test.booleanjava.helloRS.controller.lock";


    @Autowired
    private IUserService iUserService;

    @Autowired
    private Redisplus redisplus;

    @Autowired
    private RedisTemplate redisTemplate;
    RedisSerializer redisSerializer =new StringRedisSerializer();

    @RequestMapping("/hello")
    public String  hello(){
        LogUtil.info("redis的展示：[{}]", redisTemplate);
        return "hello, redis";
    }

    @RequestMapping("/set")
    public String  set(){
        Date date = new Date();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.opsForValue().set("q", "1");
        redisTemplate.opsForValue().get("q");
        System.out.println(redisTemplate.opsForValue().get("q"));
        RedisUtil.set("a1", String.valueOf(1));
        logger.info("redis的展示：[{}]", redisTemplate);
        return "hello, set一下redis";
    }

    @RequestMapping("/setex")
    public String setex( ){
//        String key = "1min";
//        int seconds = 10;
//        String value = "陈";
//        RedisUtil.setex(key, seconds, value);
//        String rs = RedisUtil.get(key);
//        logger.info("获取的值：[{}]", rs);
        String value = RedisUtil.get(USERKEY);
        if (value != null) {
            logger.info("缓存的user值：[{}]", value);
            return value;
        }
        User user = iUserService.query().eq("name", "chen").one();
        logger.info("user的值：[{}]",user.toString());
        if (user != null ) {
            RedisUtil.setex(USERKEY, 60, user.toString());
        }
        return "hello,booleanjava,设置了有时限的key";
    }

    @RequestMapping("/del")
    public String del(String key) {
        redisTemplate.delete(key);
        return "hello, del一下redis";
    }

    /**
     * 做分布锁，
     *先加锁，写业务，最后解锁
     * @return
     */
    @RequestMapping("/lock")
    public String lock() {
        //加锁
        Boolean rs =  RedisUtil.setnx(LOCKKEY,LOCKKEY);
        if (!rs){
            return "有锁了，执行失败";
        }
        //写业务代码，一人我饮酒醉
        //解锁
        RedisUtil.del(LOCKKEY);

        return "hello, lock一下redis";
    }


}
