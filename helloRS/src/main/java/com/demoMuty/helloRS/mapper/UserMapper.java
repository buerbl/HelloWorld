package com.demoMuty.helloRS.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demoMuty.helloRS.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author booleanjava
 * @since 2019-07-07
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
