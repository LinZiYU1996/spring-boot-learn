package com.example.springlearnannotation.aop.blog1;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 11:12
 * \* Description:
 * \
 */
public class Learn {
}

//aop 有一堆术语，非常难以理解，简单说一下
//
//
//通知(有的地方叫增强)(Advice)
//需要完成的工作叫做通知，就是你写的业务逻辑中需要比如事务、日志等先定义好，然后需要的地方再去用
//
//
//连接点(Join point)
//就是spring中允许使用通知的地方，基本上每个方法前后抛异常时都可以是连接点
//
//
//切点(Poincut)
//其实就是筛选出的连接点，一个类中的所有方法都是连接点，但又不全需要，会筛选出某些作为连接点做为切点。如果说通知定义了切面的动作或者执行时机的话，切点则定义了执行的地点
//
//
//切面(Aspect)
//其实就是通知和切点的结合，通知和切点共同定义了切面的全部内容，它是干什么的，什么时候在哪执行
//
//
//引入(Introduction)
//在不改变一个现有类代码的情况下，为该类添加属性和方法,可以在无需修改现有类的前提下，让它们具有新的行为和状态。其实就是把切面（也就是新方法属性：通知定义的）用到目标类中去
//
//
//目标(target)
//被通知的对象。也就是需要加入额外代码的对象，也就是真正的业务逻辑被组织织入切面。
//
//
//织入(Weaving)
//把切面加入程序代码的过程。切面在指定的连接点被织入到目标对象中，在目标对象的生命周期里有多个点可以进行织入：

/*
public class UserService{
    void save(){}
    List list(){}
    ....
}
 */

/**

 在UserService中的save()方法前需要开启事务，在方法后关闭事务，在抛异常时回滚事务。
 那么,UserService中的所有方法都是连接点(JoinPoint),save()方法就是切点(Poincut)。
 需要在save()方法前后执行的方法就是通知(Advice)，切点和通知合起来就是一个切面(Aspect)。save()方法就是目标(target)。
 把想要执行的代码动态的加入到save()方法前后就是织入(Weaving)。
 有的地方把通知称作增强是有道理的，在业务方法前后加上其它方法，其实就是对该方法的增强。

 */

/*
before(前置通知)：  在方法开始执行前执行
after(后置通知)：  在方法执行后执行
afterReturning(返回后通知)：   在方法返回后执行
afterThrowing(异常通知)： 在抛出异常时执行
around(环绕通知)：  在方法执行前和执行后都会执行

执行顺序
around > before > around > after > afterReturning

 */