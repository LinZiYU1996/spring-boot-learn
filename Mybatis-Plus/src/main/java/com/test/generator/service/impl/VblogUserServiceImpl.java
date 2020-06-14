package com.test.generator.service.impl;

import com.test.generator.entity.VblogUser;
import com.test.generator.mapper.VblogUserMapper;
import com.test.generator.service.IVblogUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
