package com.example.springbootaop.service.impl;

import com.example.springbootaop.annotation.Log;
import com.example.springbootaop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 11:52
 * \* Description:
 * \
 */


@Service
public class UserServiceImpl implements UserService {

    @Log(value = "test")
    @Override
    public String save(String user) {
        System.out.println("保存用户信息");
        if ("a".equals(user)) {
            throw new RuntimeException();
        }
        return user;
    }

    @Log(value = "test")
    @Override
    public void testAnnotationAop() {
        System.out.println("testAnnotationAop");
    }

    @Override
    public void testIntroduction() {
        System.out.println("do testIntroduction");
    }
}