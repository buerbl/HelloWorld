package com.test.booleanjava.helloRS.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.booleanjava.helloRS.entity.User;
import com.test.booleanjava.helloRS.mapper.UserMapper;
import com.test.booleanjava.helloRS.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author booleanjava
 * @since 2019-07-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
