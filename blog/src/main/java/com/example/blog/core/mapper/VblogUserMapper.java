package com.example.blog.core.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.blog.core.entity.VblogUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-06-13
 */

@Mapper
@Repository
public interface VblogUserMapper extends BaseMapper<VblogUser> {

    // 根据用户名，查询系统用户
    VblogUser queryByUserAccount(String account);

}
