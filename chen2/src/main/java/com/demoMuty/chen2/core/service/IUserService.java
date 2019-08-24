package com.demoMuty.chen2.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demoMuty.chen2.core.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author booleanjava
 * @since 2019-07-07
 */
public interface IUserService extends IService<User> {
    Boolean add(User entity);
}
