package com.test.booleanjava.helloRS.service;

import com.test.booleanjava.helloRS.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author booleanjava
 * @since 2019-07-07
 */
public interface IUserService extends IService<User> {
    /**
     * 计数器
     */
    void test();

    /**
     * 缓存
     */
    void  get();
}
