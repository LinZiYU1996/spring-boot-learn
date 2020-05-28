package com.example.jwtredis.entity;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/27
 * \* Time: 16:29
 * \* Description:
 * \
 */
public class JwtToken implements AuthenticationToken {

    private static final long serialVersionUID = 1L;
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
