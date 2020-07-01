package com.lin.dynamicdatasource;

import com.lin.dynamicdatasource.entity.User;
import com.lin.dynamicdatasource.mapper.UserMapper;
import com.lin.dynamicdatasource.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DynamicdatasourceApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService iUserService;
    @Test
    public void t1() {

        User user = new User("a",15);
//        userMapper.insert(user);
//        userMapper.s

        iUserService.save(user);
    }



}
