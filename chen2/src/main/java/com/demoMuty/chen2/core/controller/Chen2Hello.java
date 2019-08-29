package com.demoMuty.chen2.core.controller;

import com.demoMuty.chen2.core.entity.User;
import com.demoMuty.chen2.core.service.IUserService;
import com.test.base.core.provider.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

/**
 * @author booleanjava
 * Date: 2019/7/2 19:48
 * description:
 */
@RestController
@RequestMapping("/chen2")
public class Chen2Hello {

    @Autowired
    private IUserService userService;
    @Autowired(required = false)
    private DemoService demoService;
    @RequestMapping("/hello")
    public String hello(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        attributes.getRequest().getParameter("chen");
        return "s";
    }

    @Transactional
    @RequestMapping("/add")
    public Boolean add(){
        User user = new User("wen", "qwe", 1);
        userService.add(user);
        System.out.println("do");
//        throw new RuntimeException();
        return null;
    }

    @RequestMapping("/com")
    public String helloa(){
        return demoService.sayHello("wen");
    }



    @RequestMapping("/save")
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean save(){
        System.out.println("before");
        boolean flag = demoService.saveList();
        System.out.println("After");
        throw new RuntimeException();
    }


}
