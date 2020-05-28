package com.example.springbootshiro.service.impl;

import com.example.springbootshiro.entity.Role;
import com.example.springbootshiro.mapper.RoleMapper;
import com.example.springbootshiro.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
