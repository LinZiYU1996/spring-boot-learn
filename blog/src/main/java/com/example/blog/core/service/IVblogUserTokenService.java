package com.example.blog.core.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.blog.common.component.Result;
import com.example.blog.core.entity.VblogUserToken;

/**
 * <p>
 * 系统用户Token 服务类
 * </p>
 *
 * @author Lin
 * @since 2020-06-14
 */
public interface IVblogUserTokenService extends IService<VblogUserToken> {



    // 生成token

    Result createToken(long userId);


}
