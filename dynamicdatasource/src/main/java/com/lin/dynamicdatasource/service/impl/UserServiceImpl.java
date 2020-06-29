package com.lin.dynamicdatasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.dynamicdatasource.entity.User;
import com.lin.dynamicdatasource.mapper.UserMapper;
import com.lin.dynamicdatasource.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
