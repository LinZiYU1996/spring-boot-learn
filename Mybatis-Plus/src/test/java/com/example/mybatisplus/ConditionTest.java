package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
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
 * \* Time: 11:27
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest
@Slf4j
public class ConditionTest {

    @Autowired
    IUserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    public void testOne() {
        User user =  new User();
        user.setCode("701");
        user.setName("okong-condition");
        user.insert();

        Wrapper<User> qryWrapper = new EntityWrapper<>();

        qryWrapper.eq(User.CODE, user.getCode());
        qryWrapper.eq(User.NAME, user.getName());

        //也可以直接
//		qryWrapper.setEntity(user);

        //打印sql语句
        System.out.println(qryWrapper.getSqlSegment());

        //设置select 字段 即：select code,name from
        qryWrapper.setSqlSelect(User.CODE,User.NAME);
        System.out.println(qryWrapper.getSqlSelect());

//        //查询
//        User qryUser = userService.getOne(qryWrapper);
//        System.out.println(qryUser);
        log.info("拼接一结束");
    }

    @Test
    public void delete() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .isNotNull("id");
        int delete = userMapper.delete(queryWrapper);
        System.out.println("delete return count = " + delete);
    }

    /**
     * <p>
     * 根据 entity 条件，查询一条记录,
     * 这里和上方删除构造条件一样，只是seletOne返回的是一条实体记录，当出现多条时会报错
     * </p>
     */
    @Test
    public void selectOne() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "lqf");

        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }



    /**
     * <p>
     * 根据 Wrapper 条件，查询总记录数
     * </p>
     *
     * @param queryWrapper 实体对象
     */
    @Test
    public void selectCount() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "lqf");

        Integer count = userMapper.selectCount(queryWrapper);
        System.out.println(count);
    }






}
