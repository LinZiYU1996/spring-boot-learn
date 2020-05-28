package com.example.mybatisplus;

import com.example.mybatisplus.entity.MyUser;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.MyUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/20
 * \* Time: 10:28
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest
@Slf4j
public class SelectTest {

    @Autowired
    private MyUserMapper myUserMapper;


    @Test
    public void t() {

        MyUser user = myUserMapper.selectByName("a");

    }


}
