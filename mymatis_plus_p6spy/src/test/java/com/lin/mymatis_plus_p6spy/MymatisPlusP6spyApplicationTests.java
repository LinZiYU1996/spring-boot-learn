package com.lin.mymatis_plus_p6spy;

import com.lin.mymatis_plus_p6spy.entity.User;
import com.lin.mymatis_plus_p6spy.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MymatisPlusP6spyApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {

        User user = new User("33s113", 18);

        userMapper.insert(user);

    }


    @Test
    public void test1() {

        for (int i = 0; i < 100; i++) {
            User user = new User("s" + i, i+5);
            userMapper.insert(user);
        }

    }

}
