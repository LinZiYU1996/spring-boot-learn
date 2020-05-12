package com.example.springbootaop.service;

public interface UserService {

    String save(String user);

    void testAnnotationAop();

    void testIntroduction();
}


/*
在UserService中的save()方法前需要开启事务，在方法后关闭事务，在抛异常时回滚事务。
那么,UserService中的所有方法都是连接点(JoinPoint),save()方法就是切点(Poincut)。需要在save()方法前后执行的方法就是通知(Advice)，切点和通知合起来就是一个切面(Aspect)。save()方法就是目标(target)。把想要执行的代码动态的加入到save()方法前后就是织入(Weaving)。
有的地方把通知称作增强是有道理的，在业务方法前后加上其它方法，其实就是对该方法的增强。

二、常用AOP通知(增强)类型

before(前置通知)：  在方法开始执行前执行
after(后置通知)：  在方法执行后执行
afterReturning(返回后通知)：   在方法返回后执行
afterThrowing(异常通知)： 在抛出异常时执行
around(环绕通知)：  在方法执行前和执行后都会执行

around > before > around > after > afterReturning



 */