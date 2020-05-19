package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.entity.MyUser;
import com.example.mybatisplus.mapper.MyUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Console;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/18
 * \* Time: 20:18
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest
@Slf4j
public class LambdaTest {

    @Autowired
    MyUserMapper myUserMapper;



    @Test
    public void t1() {
        QueryWrapper<MyUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(MyUser::getAddress, "guangzhou");
        List<MyUser> studentList = myUserMapper.selectList(queryWrapper);
        System.out.println(studentList);

        /*

        [MyUser{id=4, name=YOkInf1, birthday=2022-01-02T15:22:43, sex=女, address=guangzhou, country=usa}, MyUser{id=8, name=ZdFhnaL, birthday=2021-11-19T18:28, sex=女, address=guangzhou, country=uk}, MyUser{id=24, name=fiEFzrT, birthday=2021-07-16T22:32:21, sex=女, address=guangzhou, country=usa}, MyUser{id=26, name=xxxxxxx, birthday=2020-08-18T04:53:56, sex=男, address=guangzhou, country=china}, MyUser{id=29, name=jyOkuT9, birthday=2021-05-31T10:27:13, sex=女, address=guangzhou, country=japan}, MyUser{id=30, name=TIn1FYD, birthday=2021-10-12T07:29:11, sex=女, address=guangzhou, country=rusain}, MyUser{id=31, name=ZJDYxwo, birthday=2021-05-12T23:14:57, sex=女, address=guangzhou, country=uk}]

         */
    }
}
