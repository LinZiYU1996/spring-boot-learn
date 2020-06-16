package com.example.blog.core.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.blog.core.entity.VblogUserToken;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统用户Token Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-06-14
 */

@Mapper
@Repository
public interface VblogUserTokenMapper extends BaseMapper<VblogUserToken> {
    VblogUserToken queryByToken(String token);

}
