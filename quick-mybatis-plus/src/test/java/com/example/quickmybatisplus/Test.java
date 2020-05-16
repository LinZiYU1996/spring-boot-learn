package com.example.quickmybatisplus;

import com.example.quickmybatisplus.entity.MyUser;
import com.example.quickmybatisplus.mapper.MyUserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/15
 * \* Time: 11:28
 * \* Description:
 * \
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {


    @Autowired
    MyUserMapper myUserMapper;

    @org.junit.Test

    public void insert(){
        MyUser myUser = new MyUser(1,"a","123",new Date().toString());


        myUserMapper.insert(myUser);
    }
}
