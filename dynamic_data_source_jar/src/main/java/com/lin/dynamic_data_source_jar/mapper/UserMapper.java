package com.lin.dynamic_data_source_jar.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.dynamic_data_source_jar.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-06-28
 */

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
