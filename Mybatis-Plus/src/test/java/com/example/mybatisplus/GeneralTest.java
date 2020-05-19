package com.example.mybatisplus;

import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/18
 * \* Time: 11:06
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest
@Slf4j
public class GeneralTest {
/*
MP提供了ActiveRecord的支持，所以实体类只需继承 Model 类即可实现基本 CRUD 操作。
 */
    @Autowired
    IUserService userService;


    @Test
    public void testInsert() {
        User user = new User();
        user.setCode("002");
        user.setName("docker-insert");
        //默认的插入策略为：FieldStrategy.NOT_NULL，即：判断 null
        //对应在mapper.xml时写法为：<if test="field!=null">
        //这个可以修改的，设置字段的@TableField(strategy=FieldStrategy.NOT_EMPTY)
        //所以这个时候，为null的字段是不会更新的，也可以开启性能插件，查看sql语句就可以知道
        userService.save(user);
        log.info("新增结束");


    }


    @Test
    public void testUpdate() {

        User user = new User();
        user.setCode("101");
        user.setName("oKong-insert");
        //这就是ActiveRecord的功能
        user.insert();
        //也可以直接 userService.insert(user);

        //更新
        User updUser = new User();
        updUser.setId(user.getId());
        updUser.setName("okong-upd");

        updUser.updateById();
        log.info("更新结束");
    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setCode("101");
        user.setName("oKong-delete");

        user.insert();

        //删除
        user.deleteById();
        log.info("删除结束");

    }




}
