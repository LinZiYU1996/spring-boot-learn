package com.example.login.util;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/8
 * \* Time: 10:11
 * \* Description:
 * \
 */
public class Msg {

    private int code;

    private String msg;

    private Msg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Msg ok(String msg) {
        return new Msg(200, msg);
    }

    public static Msg error(String msg) {
        return  new Msg(400,msg);
    }
}
