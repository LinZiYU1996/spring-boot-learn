package com.example.quickmybatisplus;

import com.example.quickmybatisplus.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class QuickMybatisPlusApplicationTests {

    @Test
    void contextLoads() {
    }


    /**
     * 新增数据
     */
    @Test
    public void testAdd() throws Exception{
        User entity = new User();
        entity.setUsername("admi111n");
        entity.setPassword("123451116");
        entity.setNickName("管理员1111");
        entity.insert();
    }


}
