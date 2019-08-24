package com.test.chen1.core.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.chen1.core.entity.User;
import com.test.chen1.core.mapper.UserMapper;
import com.test.chen1.core.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author booleanjava
 * @since 2019-07-07
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
