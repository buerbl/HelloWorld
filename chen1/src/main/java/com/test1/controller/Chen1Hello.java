package com.test1.controller;

import com.test1.provider.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boolean
 * Date: 2019/7/2 19:48
 * description:
 */
@RestController("/chen1")
public class Chen1Hello {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/hello")
    public String hello(){
        return "he";
    }

    @RequestMapping("/chen")
    public String hello1(){
        return demoService.sayHello("chen");
    }


}
