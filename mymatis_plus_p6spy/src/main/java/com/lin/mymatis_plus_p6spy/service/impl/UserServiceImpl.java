package com.lin.mymatis_plus_p6spy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.mymatis_plus_p6spy.entity.User;
import com.lin.mymatis_plus_p6spy.mapper.UserMapper;
import com.lin.mymatis_plus_p6spy.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-06-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
