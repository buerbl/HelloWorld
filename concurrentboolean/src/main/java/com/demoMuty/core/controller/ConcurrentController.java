package com.demoMuty.core.controller;

import com.demoMuty.core.entity.DTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boolean
 * Date: 2019/7/9 19:53
 * description:
 */
@Slf4j
@RestController
@RequestMapping("/concurrentController")
public class ConcurrentController {

    @RequestMapping("/hello")
    public String hello(@RequestBody DTO name){
        log.info("namd的值[{}]", name);
        log.info("hello,concurrentController");
        return "hello,concurrentController";
    }

    @RequestMapping("/test")
    public void test(){
        log.info("test");
    }

}
