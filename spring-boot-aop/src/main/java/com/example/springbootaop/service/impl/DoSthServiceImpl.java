package com.example.springbootaop.service.impl;

import com.example.springbootaop.service.DoSthService;
import org.springframework.stereotype.Service;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 11:52
 * \* Description:
 * \
 */
@Service
public class DoSthServiceImpl implements DoSthService {

    @Override
    public void doSth() {
        System.out.println("do sth ....");
    }

}