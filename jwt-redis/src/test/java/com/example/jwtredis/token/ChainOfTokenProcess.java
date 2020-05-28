package com.example.jwtredis.token;

import com.example.jwtredis.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/27
 * \* Time: 16:35
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
    public String createToken() {

        String token = JwtUtil.sign(username, secret);

        log.info(token);

        return token;
    }

}
