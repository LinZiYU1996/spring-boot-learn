package com.example.springbootmysql;

import com.example.springbootmysql.pojo.User;
import com.example.springbootmysql.pojo.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;

@SpringBootTest
class SpringBootMysqlApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
        sdf.format(new Date());
//        userDao.save(new User(11L, "jack", "123"));
//        Assert.assertEquals(3, userDao.findAll().size());
        System.out.println(userDao.findByUserName("jack").getPassword());
        Assert.assertEquals("123", userDao.findByUserName("jack").getPassword());
        List<Long> list = new ArrayList<Long>();
        list.add(1L);
        list.add(2L);
        List<User> userList = userDao.findAllByIdIsIn(list);
        for (User user : userList){
            System.out.println(user.getUserName());
        }
    }



}
