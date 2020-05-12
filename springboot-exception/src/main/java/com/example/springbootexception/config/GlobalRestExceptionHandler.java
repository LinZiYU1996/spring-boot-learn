package com.example.springbootexception.config;

import com.example.springbootexception.exception.BaseException;
import com.example.springbootexception.web.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 19:53
 * \* Description:
 * \
 */

@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BaseException.class)
    public ResponseResult baseException(BaseException e) {
        return new ResponseResult<>(e.getCode(), e.getMessage());
    }


}
