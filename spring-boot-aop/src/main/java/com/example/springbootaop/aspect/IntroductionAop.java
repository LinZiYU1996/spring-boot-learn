package com.example.springbootaop.aspect;

import com.example.springbootaop.service.DoSthService;
import com.example.springbootaop.service.impl.DoSthServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 11:50
 * \* Description:
 * \
 */

@Aspect
@Component
public class IntroductionAop {

    @DeclareParents(value = "com.example..service..*", defaultImpl = DoSthServiceImpl.class)
    public DoSthService doSthService;


}
