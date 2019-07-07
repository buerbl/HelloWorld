package com.test.base.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author booleanjava
 * Date: 2019/7/2 19:48
 * description:
 */
@RequestMapping("/base")
@RestController
public class BaseHello {
    @RequestMapping("/hello")
    public String hello11(){
        return "he";
    }

}
