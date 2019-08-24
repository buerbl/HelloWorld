package com.test.chen1.core.dubbo;

import com.test.base.core.provider.DemoService;
import com.test.chen1.core.entity.User;
import com.test.chen1.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author buer
 * create 2019/7/2 22:14
 * description
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {
    @Autowired
    private IUserService iUserService;
    @Override
    public String sayHello(String name) {
        return "hello,dubbo"+name;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Boolean saveList() {
        List<User> chen = Stream.of(new User("chen", "123", 1)).collect(Collectors.toList());
        return iUserService.saveBatch(chen);
    }
}
