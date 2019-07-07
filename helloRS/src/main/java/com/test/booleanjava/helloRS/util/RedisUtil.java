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

}
