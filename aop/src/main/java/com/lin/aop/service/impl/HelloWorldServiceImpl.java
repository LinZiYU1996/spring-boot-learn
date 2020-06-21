package com.lin.aop.service.impl;

import com.lin.aop.annotation.AnalysisActuator;
import com.lin.aop.service.HelloWorldService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/20
 * \* Time: 11:35
 * \* Description:
 * \
 */

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @AnalysisActuator(note = "获取聊天信息方法")
    @Override
    public String getHelloMessage(String name) {
        return "Hello " + Optional.ofNullable(name).orElse("World!");
    }
}
