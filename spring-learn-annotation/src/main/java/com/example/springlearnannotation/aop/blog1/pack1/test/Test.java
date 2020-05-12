package com.example.springlearnannotation.aop.blog1.pack1.test;

import com.example.springlearnannotation.aop.blog1.pack1.DoSthService;
import com.example.springlearnannotation.aop.blog1.pack1.UserService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 11:17
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Resource
    private UserService userService;

    @org.junit.Test
    public void testIntroduction() {
        userService.testIntroduction();
        //Aop 让UserService方法拥有 DoSthService的方法
        DoSthService doSthService = (DoSthService) userService;
        doSthService.doSth();
    }



}
