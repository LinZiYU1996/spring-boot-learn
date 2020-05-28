package com.example.jwtredis.test;

import com.example.jwtredis.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/27
 * \* Time: 16:40
 * \* Description:
 * \
 */

@Slf4j
public class ChainOfTokenProcess {

    //* @param username 用户名
    //* @param secret   用户的密码

    String username = "Jack";

    String secret = "abcdfjchinaea";

    @Test
    public void createToken() {

        String token = JwtUtil.sign(username, secret);

        log.info(token);

    }

    @Test
    public void getMsgFromToken() {

        String token = JwtUtil.sign(username, secret);

        log.info(JwtUtil.getUsername(token));



    }


    @Test
    public void vertify() {
        String token = JwtUtil.sign(username, secret);

        log.info(JwtUtil.verify(token, username, secret) + " {}{}");

    }


}
