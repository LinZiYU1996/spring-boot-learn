package com.example.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/18
 * \* Time: 11:33
 * \* Description:
 * \
 */
@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest
@Slf4j
public class MapperTest {


    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {

        User user =  new User();
        user.setCode("888");
        user.setName("okong-2326");
        userMapper.insert(user);
        log.info("完成");

    }

//    @Test
//    public void testCustomSql() {
//        User user = new User();
//        user.setCode("703");
//        user.setName("okong-condition");
//        user.insert();
//
//        EntityWrapper<User> qryWrapper = new EntityWrapper<>();
//        qryWrapper.eq(User.CODE, user.getCode());
//
//        RowBounds pageUser = new Page<>();
//        pageUser.setCurrent(1);
//        pageUser.setSize(10);
//
//        List<User> userlist = userMapper.selectUserWrapper(pageUser, qryWrapper);
//        System.out.println(userlist.get(0));
//        log.info("自定义sql结束");
//    }


}
