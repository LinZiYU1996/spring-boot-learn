package com.example.springlearnannotation.chapter4.intercept;

import com.example.springlearnannotation.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 9:53
 * \* Description:
 * \
 */
public class MyInterceptor implements Interceptor{

    @Override
    public boolean before() {
        System.out.println("before");
        return true;
    }

    @Override
    public void after() {

        System.out.println("after");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before.........................");
        Object o = invocation.proceed();
        System.out.println("around after.........................");

        return o;
    }

    @Override
    public void afterReturning() {

        System.out.println("afterReturning............................");
    }

    @Override
    public void afterThrowing() {

        System.out.println("afterThrowing...............................");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
