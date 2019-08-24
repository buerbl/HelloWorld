package com.demoMuty.chen2.core.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demoMuty.chen2.core.entity.User;
import com.demoMuty.chen2.core.mapper.UserMapper;
import com.demoMuty.chen2.core.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public  Boolean add(User entity){

        return save(entity);
    }

}
