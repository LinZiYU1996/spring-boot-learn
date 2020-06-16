package com.example.blog.core.service.impl;

import com.example.blog.core.entity.VblogUser;
import com.example.blog.core.entity.VblogUserToken;
import com.example.blog.core.mapper.VblogUserMapper;
import com.example.blog.core.mapper.VblogUserTokenMapper;
import com.example.blog.core.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/14
 * \* Time: 12:06
 * \* Description:
 * \
 */

@Service

public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private VblogUserMapper userDao;
    @Autowired
    private VblogUserTokenMapper userTokenDao;


    @Override
    public Set<String> getUserPermissions(long userId) {
        return null;
    }

    @Override
    public VblogUserToken queryByToken(String token) {
        return userTokenDao.queryByToken(token);
    }

    @Override
    public VblogUser queryUser(Long userId) {
        return userDao.selectById(userId);
    }
}
