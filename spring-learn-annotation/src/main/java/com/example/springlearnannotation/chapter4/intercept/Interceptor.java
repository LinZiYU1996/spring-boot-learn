package com.example.springlearnannotation.chapter4.intercept;


import com.example.springlearnannotation.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {

    public boolean before();

    public void after();


    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    public void afterReturning();

    public void afterThrowing();

    boolean useAround();
}
