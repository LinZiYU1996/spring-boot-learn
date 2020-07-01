package com.lin.dynamic_data_source_jar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.dynamic_data_source_jar.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lin
 * @since 2020-06-28
 */
public interface IUserService extends IService<User> {


    void insertBySlave1(User user);
}
