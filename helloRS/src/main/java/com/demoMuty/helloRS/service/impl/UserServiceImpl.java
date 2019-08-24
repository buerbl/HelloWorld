package com.demoMuty.helloRS.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demoMuty.helloRS.entity.User;
import com.demoMuty.helloRS.mapper.UserMapper;
import com.demoMuty.helloRS.service.IUserService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author booleanjava
 * @since 2019-07-07
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private StringRedisTemplate redisTemplate;
    public void test(){
        log.info("sssss");
        log.info(String.valueOf(redisTemplate));
        String qww = redisTemplate.opsForValue().get("QWW");
        if (qww != null){
            Long qww1 = redisTemplate.opsForValue().increment("QWW", 1);
            log.info("值为:[{}]", qww1);
            if (qww1 > 10){
                throw new RuntimeException("限制");
            }

        }else {
            redisTemplate.opsForValue().set("QWW", String.valueOf(1), 100L, TimeUnit.SECONDS);
        }


    }

    @Override
    public void get() {
        User user = new User();
        user.setName("陈**");
        Gson gson = new Gson();
        String toJson = gson.toJson(user);
        redisTemplate.opsForValue().set("name", toJson);
        String name = redisTemplate.opsForValue().get("name");
        User user1 = gson.fromJson(name, User.class);
        log.info("user1的值：[{}]",user1.getName() );


    }

    @Override
    public boolean insertLeaderboard() {
        Double score = getScore(100l, 1000l);
        return redisTemplate.opsForZSet().add("leaderboard", "1", score);
    }

    @Override
    public Set checkLeaderboard() {
        // 0 -1 表示返回所有的value的set值
        return redisTemplate.opsForZSet().range("leaderboard", 0, -1);
    }

    private Double getScore( Long oneDayGoldBean, Long useTime) {
        String value1 = String.valueOf(oneDayGoldBean/1.0);
        long todayEndSS = getTodayEndSS(useTime);
        String value2 = String.valueOf(todayEndSS);
        String score =value1+value2;
        return -Double.valueOf(score);
    }

    private long getTodayEndSS(long current){
        //今天零点零分零秒的毫秒数
        long zero = 0L;
        //今天23点59分59秒的毫秒数
        long twelve = zero + 24 * 60 * 60 * 1000;
        return (twelve - current) / 1000;
    }

}
