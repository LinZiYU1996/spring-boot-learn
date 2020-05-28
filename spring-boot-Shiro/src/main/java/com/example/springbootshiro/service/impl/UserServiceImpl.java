package com.example.springbootshiro.service.impl;

import com.example.springbootshiro.entity.User;
import com.example.springbootshiro.mapper.UserMapper;
import com.example.springbootshiro.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-05-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
