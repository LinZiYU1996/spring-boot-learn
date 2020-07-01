package com.lin.dynamic_data_source_jar;

import com.lin.dynamic_data_source_jar.entity.User;
import com.lin.dynamic_data_source_jar.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DynamicDataSourceJarApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private UserMapper userMapper;


    @Test
    public void t1() {

        User user = new User("ksisis",789);
        userMapper.insert(user);

    }
}
