package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.mybatisplus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-05-18
 */
public interface UserMapper extends BaseMapper<User> {


    List<User> selectUserWrapper(RowBounds rowBounds, @Param("ew") Wrapper<User> wrapper);

}
