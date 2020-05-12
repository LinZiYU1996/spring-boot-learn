package com.example.springlearnannotation.aop.blog1.pack1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 11:15
 * \* Description:
 * \
 */

@Aspect
@Component
public class IntroductionAop {

    @DeclareParents(value = "com.example..pack1..*", defaultImpl = DoSthServiceImpl.class)
    public DoSthService doSthService;


}
