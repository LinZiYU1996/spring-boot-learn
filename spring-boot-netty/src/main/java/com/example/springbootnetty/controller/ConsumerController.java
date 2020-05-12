package com.example.springbootnetty.controller;

import com.example.springbootnetty.client.NettyClient;
import com.sun.corba.se.impl.protocol.giopmsgheaders.MessageBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/9
 * \* Time: 11:27
 * \* Description:
 * \
 */

@RestController
public class ConsumerController {

    @Autowired
    private NettyClient nettyClient;

    @GetMapping("/send")
    public String send() {

        String s = "hello world";
        nettyClient.sendMsg(s);
        return "send ok";
    }
}
