package com.test.concurrentboolean.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boolean
 * Date: 2019/7/9 19:53
 * description:
 */

@RestController
@RequestMapping("/concurrentboolean/concurrentController")
public class ConcurrentController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello,concurrentController";
    }
}
