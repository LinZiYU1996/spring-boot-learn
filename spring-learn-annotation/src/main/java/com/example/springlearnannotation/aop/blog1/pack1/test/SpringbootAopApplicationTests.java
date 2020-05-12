package com.example.springlearnannotation.aop.blog1.pack1.test;

import com.example.springlearnannotation.aop.blog1.pack1.UserService;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 11:36
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAopApplicationTests {

    @Resource
    private UserService userService;

    @org.junit.Test
    public void testAop1() {
        userService.save("张三");
        Assert.assertTrue(true);
    }

    @org.junit.Test
    public void testAop2() {
        userService.save("a");
    }

    @org.junit.Test
    public void testAop3() {
        userService.testAnnotationAop();
    }


}
