package com.demoMuty.helloRS.service;

import com.demoMuty.helloRS.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

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

    /**
     *插入排行榜
     */
    boolean insertLeaderboard();

    /**
     * 查询排行榜
     */
    Set checkLeaderboard();

}
