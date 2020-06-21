package com.lin.aop2.pointcut;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/20
 * \* Time: 16:33
 * \* Description:
 * \
 */
@Aspect
@Component
public class Audience2 {

    @Pointcut("execution(* com.lin.aop2.pointcut.Performence.play(..))")
    public void performance(){}


    //定义一个环绕通知：

    //从上面的代码可以看出
    // ，环绕通知跟前置通知和后置通知不同的是，
    // 它会在一个方法的执行之前和执行之后都会执行一些操作。关于这个通
    // 知方法，可以看到它接收了一个ProceedingJoinPoint对象作为参数。这
    // 个对象是必须要有的，因为我们要在通知中通过它来调用被通知的方法。通知
    // 方法中可以做任何的事情，当要将控制权交给被通知的方法时，它需要调用P
    // roceedingJoinPoint 的 proceed()方法


    @Around("performance()")
    public void countTimeMillis(ProceedingJoinPoint pJoinPoint){
        try {
            long date1 = System.currentTimeMillis();

            pJoinPoint.proceed();  //将控制权移交给被通知方法

            long date2 = System.currentTimeMillis();

            System.out.println("执行方法耗时： " + (date2 - date1));
        } catch (Throwable e) {
            System.out.println("Around--表演失败");
        }
    }
}
