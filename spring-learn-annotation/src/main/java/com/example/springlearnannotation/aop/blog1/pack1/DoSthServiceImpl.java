package com.example.springlearnannotation.aop.blog1.pack1;

import org.springframework.stereotype.Service;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 11:16
 * \* Description:
 * \
 */

@Service
public class DoSthServiceImpl implements DoSthService{

    @Override
    public void doSth() {
        System.out.println("do sth ....");
    }
}
