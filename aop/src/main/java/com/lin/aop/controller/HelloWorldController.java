package com.lin.aop.controller;

import com.lin.aop.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/20
 * \* Time: 11:34
 * \* Description:
 * \
 */
@RestController
public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        return helloWorldService.getHelloMessage(name);
    }
}
