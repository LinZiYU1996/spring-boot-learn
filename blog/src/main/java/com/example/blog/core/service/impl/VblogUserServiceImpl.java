package com.example.blog.core.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.blog.core.entity.VblogUser;
import com.example.blog.core.mapper.VblogUserMapper;
import com.example.blog.core.service.IVblogUserService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-06-13
 */
@Service
public class VblogUserServiceImpl extends ServiceImpl<VblogUserMapper, VblogUser> implements IVblogUserService {


    @Override
    public VblogUser queryByUserAccount(String username) {
        return baseMapper.queryByUserAccount(username);
    }
}
