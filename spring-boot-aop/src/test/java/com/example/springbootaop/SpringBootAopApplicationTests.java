package com.example.springbootaop;

import com.example.springbootaop.service.DoSthService;
import com.example.springbootaop.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootAopApplicationTests {

    @Test
    void contextLoads() {
    }


    @Resource
    private UserService userService;

    @Test
    public void testAop() {
        userService.save("张三");
        Assert.assertTrue(true);

        /*

test
around
注解式拦截 test
around
before beginTransaction
保存用户信息
around
after commit
afterReturning :: 张三
张三
around
         */
    }

    @Test
    public void testAop2() {
        userService.save("a");
    }

    @Test
    public void testAop3() {
        userService.testAnnotationAop();

        /*

test
around
注解式拦截 test
testAnnotationAop
null
around
         */
    }

    @Test
    public void testIntroduction() {
        userService.testIntroduction();
        //Aop 让UserService方法拥有 DoSthService的方法
        DoSthService doSthService = (DoSthService) userService;
        doSthService.doSth();


        /*
        do testIntroduction
        do sth ....
         */
    }


}
