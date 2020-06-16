package com.example.blog.core.service;

import com.example.blog.core.entity.VblogUser;
import com.example.blog.core.entity.VblogUserToken;

import java.util.Set;

public interface ShiroService {

    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    VblogUserToken queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     *
     * @param userId
     */
    VblogUser queryUser(Long userId);


}
