package com.lin.aop2.pointcut;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/20
 * \* Time: 16:29
 * \* Description:
 * \
 */
//@Aspect
//@Component
public class Audience1 {

    /**
     * 定义了一个切点，其值是一个切点表达式，含义是：
     * 在这个类的这个方法的执行前和执行后触发下面定义的“通知”
     * 前面的*表示任意返回值，后面的点则表示任意多个参数，也就是所有名为play的方法的任意重载的方法都会触发此通知
     */
    @Pointcut("execution(* com.lin.aop2.pointcut.Performence.play(..))")
    public void performance(){}

    @Before("performance()")
    public void seat(){
        System.out.println("坐下");
    }
//从上面的代码可以看出，这里使用@Pointcut注解给被@Aspect注解标注的切面定义了一个可重用的切点。
// 这样在使用其他通知时就可以直接在该切点商织入通知了，也就是使用被@Pointcut注解标注的 performance() 方法
//
//注：这里的 performance() 方法的实际内容并不重要，在这里它实际上应该是空的。这个方法本
// 身只是一个标志，供@Pointcut这个注解依附
    @Before("performance()")
    public void silence(){
        System.out.println("保持安静");
    }

    @AfterReturning("performance()")
    public void applause(){
        System.out.println("鼓掌hhhhh");
    }

    @AfterThrowing("performance()")
    public void fail(){
        System.out.println("表演失败");
    }
}
