package com.example.springbootexception.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 19:54
 * \* Description:
 * \
 */


@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException{

    private Integer code;
    private String message;

    public BaseException(String message) {
        super(message);
        this.code = HttpStatus.BAD_REQUEST.value();
        this.message = message;
    }

    public BaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
