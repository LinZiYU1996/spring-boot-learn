package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.entity.MyUser;
import com.example.mybatisplus.mapper.MyUserMapper;
import com.example.mybatisplus.service.IMyUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-05-18
 */
@Service
public class MyUserServiceImpl extends ServiceImpl<MyUserMapper, MyUser> implements IMyUserService {

}
