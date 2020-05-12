package com.example.springlearnannotation.chapter4.service.impl;

import com.example.springlearnannotation.chapter4.service.HelloService;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 9:38
 * \* Description:
 * \
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if (name == null || name.trim() == "") {
            throw new RuntimeException("parameter is null");
        }
        System.out.println("hello " + name);
    }
}
