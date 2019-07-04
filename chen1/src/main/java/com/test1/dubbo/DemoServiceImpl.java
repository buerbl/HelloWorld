package com.test1.dubbo;

import com.test1.provider.DemoService;
import org.springframework.stereotype.Service;

/**
 * @author buer
 * create 2019/7/2 22:14
 * description
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "hello,dubbo"+name;
    }
}
