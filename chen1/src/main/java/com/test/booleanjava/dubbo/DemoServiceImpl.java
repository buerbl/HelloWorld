package com.test.booleanjava.dubbo;

import com.test.booleanjava.provider.DemoService;
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
