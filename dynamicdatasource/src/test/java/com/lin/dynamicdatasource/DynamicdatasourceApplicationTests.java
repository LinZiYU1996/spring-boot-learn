package com.lin.dynamicdatasource;

import com.lin.dynamicdatasource.entity.User;
import com.lin.dynamicdatasource.mapper.UserMapper;
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

    @Test
    public void t1() {

        User user = new User("a",15);
        userMapper.insert(user);

    }



}
