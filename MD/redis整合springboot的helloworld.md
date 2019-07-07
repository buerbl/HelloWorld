## 引入依赖
```gradle
 compile 'org.springframework.boot:spring-boot-starter-data-redis'
```
使用redis有两种方法
1. Jedis

```java
Jedis jedis = new Jedis("localhost");
```

2.RedisTemplate

```java
@Autowired
private RedisTemplate redisTemplate;
```

如果使用RedisTemplate的话，要在application.properties中配置信息，这里我使用Jedis比较简单

## redis的自动配置

在application.properties文件下

``` 
#redis的springboot的自动配置
# Redis数据库索引（默认为0）
spring.redis.database=0
# Redis服务器地址
spring.redis.host=127.0.0.1
# Redis服务器连接端口
spring.redis.port=6379  
# Redis服务器连接密码（默认为空）
spring.redis.password=
# 连接池最大连接数（使用负值表示没有限制）
spring.redis.pool.max-active=8  
# 连接池最大阻塞等待时间（使用负值表示没有限制）
spring.redis.pool.max-wait=-1  
# 连接池中的最大空闲连接
spring.redis.pool.max-idle=8  
# 连接池中的最小空闲连接
spring.redis.pool.min-idle=0  
# 连接超时时间（毫秒）
spring.redis.timeout=0
```

## Jedis使用

```java
package com.test.booleanjava.helloRS.util;

import redis.clients.jedis.Jedis;

/**
 * @author booleanjava
 * Date: 2019/7/2 19:48
 * description:redis的工具类
 */
public class RedisUtil {
    static Jedis jedis = new Jedis("localhost");

    /**
     * 插入key，如果存在就更新
     * @param key
     * @param value
     * @return
     */
    public static   String set(String key, String value){
        return  jedis.set(key, value);
    }

    /**
     * 获取key的值
     * @param key
     * @return
     */
    public static String get(String key) {
        return jedis.get(key);
    }

    /**
     * 删除key
     * @param key
     * @return
     */
    public static Long del(String key){
        return jedis.del(key);
    }

    /**
     * 设置一个有过期时间的key（秒）
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    public static String setex(final String key, final int seconds, final String value){
        return jedis.setex(key, seconds, value);
    }

    /**
     * 如果不存在就执行操作，用作简单分布式锁
     *
     * @param key
     * @param value
     * @return true表示执行，false表示没有执行
     */
    public static Boolean setnx(final String key, final String value){
        return jedis.setnx(key, value) == 1;
    }

}

```

## RedisTemplates使用

```java
package com.test.booleanjava.helloRS.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author boolean
 * Date: 2019/7/2 19:48
 * description:
 */

@Component
public class Redisplus {

    @Autowired
    private  RedisTemplate redisTemplate;

    public  void set(String key, String value){
        redisTemplate.opsForValue().set(key, value);

    }
}
```

## 测试
```java
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
        RedisUtil.setnx(LOCKKEY,LOCKKEY);
        //写业务代码，一人我饮酒醉

        //解锁
        RedisUtil.del(LOCKKEY);

        return "hello, lock一下redis";
    }
}
```

## 源码
https://github.com/blackdogss/HelloWorld/tree/master/helloRS

