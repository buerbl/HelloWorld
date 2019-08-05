package com.test.booleanjava.helloRS.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.test.booleanjava.helloRS.entity.User;
import com.test.booleanjava.helloRS.mapper.UserMapper;
import com.test.booleanjava.helloRS.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

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
    @Override
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
        user.setName("陈文观");
        Gson gson = new Gson();
        String toJson = gson.toJson(user);
        redisTemplate.opsForValue().set("name", toJson);
        String name = redisTemplate.opsForValue().get("name");
        User user1 = gson.fromJson(name, User.class);
        log.info("user1的值：[{}]",user1.getName() );


    }
}
