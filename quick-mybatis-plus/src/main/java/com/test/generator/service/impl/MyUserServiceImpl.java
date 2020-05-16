package com.test.generator.service.impl;

import com.example.quickmybatisplus.entity.MyUser;
import com.example.quickmybatisplus.mapper.MyUserMapper;
import com.test.generator.service.IMyUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-05-15
 */
@Service
public class MyUserServiceImpl extends ServiceImpl<MyUserMapper, MyUser> implements IMyUserService {

}
