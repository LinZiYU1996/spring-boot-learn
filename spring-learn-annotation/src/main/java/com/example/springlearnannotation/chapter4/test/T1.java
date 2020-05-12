package com.example.springlearnannotation.chapter4.test;

import com.example.springlearnannotation.chapter4.intercept.Interceptor;
import com.example.springlearnannotation.chapter4.intercept.MyInterceptor;
import com.example.springlearnannotation.chapter4.service.HelloService;
import com.example.springlearnannotation.chapter4.service.impl.HelloServiceImpl;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 9:56
 * \* Description:
 * \
 */
public class T1 {


    private static void testProxy() {
        HelloService helloService = new HelloServiceImpl();

        HelloService proxy = (HelloService) ProxyBean.getProxyBean(
                helloService, new MyInterceptor()
        );

        proxy.sayHello("JONHN");

        System.out.println("|||||||||||||||||||||||||||");

        proxy.sayHello(null);

    }

    public static void main(String[] args) {


        testProxy();

    }
}

//before
//around before.........................
//hello JONHN
//around after.........................
//after
//afterReturning............................
//|||||||||||||||||||||||||||
//before
//around before.........................
//after
//afterThrowing...............................