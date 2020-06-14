package com.example.blog.common.exception;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/12
 * \* Time: 9:34
 * \* Description:
 * \
 */
public class RestException extends  RuntimeException{

    // 自定义异常

    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public RestException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RestException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public RestException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public RestException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
