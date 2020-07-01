package com.lin.dynamic_data_source_jar.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.dynamic_data_source_jar.entity.User;
import com.lin.dynamic_data_source_jar.mapper.UserMapper;
import com.lin.dynamic_data_source_jar.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-06-28
 */
@Service
@DS("slave1")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertBySlave1(User user) {
        userMapper.insert(user);
    }
}
