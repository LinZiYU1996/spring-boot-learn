package com.example.springlearnannotation.aop.blog2;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 11:44
 * \* Description:
 * \
 */

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 类定义为切面类
 */
@Aspect
@Component

public class AopTestController {

    private static final Logger logger = LoggerFactory.getLogger(AopTestController.class);
    /**
     * 定义一个切点
     */
    @Pointcut(value = "execution(public String test (..))")
    public void cutOffPoint() {
    }
}
