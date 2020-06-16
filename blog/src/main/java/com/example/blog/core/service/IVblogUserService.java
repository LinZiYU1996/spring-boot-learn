package com.example.blog.core.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.blog.core.entity.VblogUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Lin
 * @since 2020-06-13
 */
public interface IVblogUserService extends IService<VblogUser> {

    // 根据用户名，查询系统用户

    VblogUser queryByUserAccount(String username);

}
