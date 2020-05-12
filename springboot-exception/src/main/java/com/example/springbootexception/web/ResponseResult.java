package com.example.springbootexception.web;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 19:55
 * \* Description:
 * \
 */

@Data

public class ResponseResult<T> {

    private Integer code;
    private String message;
    private T data;

    public ResponseResult(T data) {
        this.code = HttpStatus.OK.value();
        this.data = data;
    }

    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
