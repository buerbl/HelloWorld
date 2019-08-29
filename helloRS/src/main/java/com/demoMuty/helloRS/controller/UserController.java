package com.demoMuty.helloRS.controller;


import com.demoMuty.helloRS.entity.User;
import com.demoMuty.helloRS.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author booleanjava
 * @since 2019-07-07
 */
@RestController
@RequestMapping("/helloRS/redisHello/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/add")
    public void add(){
        User user = new User("CHEN", "WEN", 1);
        userService.save(user);

    }
}

