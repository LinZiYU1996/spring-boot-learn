package com.lin.aop2.pointcut;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/20
 * \* Time: 16:13
 * \* Description:
 * \
 */
//在使用注解定义一个切面时，需要添加的注解是：@Aspect
//@Aspect
//@Component
public class Audience0 {
//@Before：定义一个前置通知
//@AfterReturning：定义一个返回通知
//@AfterThrowing：定义一个异常通知
    @Before("execution(* com.lin.aop2.pointcut.Performence.play(..))")
    public void seat(){
        System.out.println("坐下");
    }

    @Before("execution(* com.lin.aop2.pointcut.Performence.play(..))")
    public void silence(){
        System.out.println("保持安静");
    }

    @AfterReturning("execution(* com.lin.aop2.pointcut.Performence.play(..))")
    public void applause(){
        System.out.println("鼓掌");
    }

    @AfterThrowing("execution(* com.lin.aop2.pointcut.Performence.play(..))")
    public void fail(){
        System.out.println("表演失败");
    }
}
