package com.example.springlearnannotation.chapter4.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 9:42
 * \* Description:
 * \
 */
public class Invocation {

    private Object[] params;

    private Method method;

    private Object target;

    public Invocation(Object target,Method method,Object[] params) {
        this.params = params;
        this.method = method;
        this.target = target;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }


}
