package com.example.redistest;

import com.example.redistest.entity.UserEntity;
import com.example.redistest.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/28
 * \* Time: 15:45
 * \* Description:
 * \
 */

@SpringBootTest
public class OperationTest {

    @Autowired
    RedisUtil redisUtil;

    // 测试 设置键值对 以及过期时间
    @Test
    public void test_set(){

        redisUtil.set("1",new UserEntity());

    }

    @Test
    public void test_set1(){

        redisUtil.set("1assas",new UserEntity(),5);

    }

    @Test
    public void test_Set() {
        redisUtil.sSet("set","abc","dkj");
    }

    @Test
    public void test_set_list() {

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            integers.add(i);
        }

        redisUtil.lSet("list", integers);
    }
}
