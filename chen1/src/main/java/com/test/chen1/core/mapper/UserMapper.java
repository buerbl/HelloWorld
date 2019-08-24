package com.test.chen1.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.chen1.core.entity.User;
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
