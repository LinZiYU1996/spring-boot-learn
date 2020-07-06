package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.mybatisplus.entity.MyUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-05-18
 */

@Repository
public interface MyUserMapper extends BaseMapper<MyUser> {

    @Select("select * from my_user")
    List<MyUser> getAll();


    @Select("select * from my_user where name = #{name} ")
    MyUser selectByName(@Param("name") String name);

}
