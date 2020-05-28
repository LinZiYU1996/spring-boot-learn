package com.example.springbootshiro.mapper;

import com.example.springbootshiro.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-05-20
 */

@Repository
public interface UserMapper extends BaseMapper<User> {


    @Select("select\n" +
            "          *\n" +
            "            from user\n" +
            "        where account = #{account}")
    User findByAccount(@Param("account") String account);

}
