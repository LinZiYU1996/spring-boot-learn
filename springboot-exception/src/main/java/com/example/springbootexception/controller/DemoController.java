package com.example.springbootexception.controller;

import com.example.springbootexception.exception.BaseException;
import com.example.springbootexception.web.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 19:54
 * \* Description:
 * \
 */

@RestController
public class DemoController {

    @GetMapping(value = "/test")
    public ResponseResult<String> test(String a) {
        if ("a".equals(a)) throw new BaseException("失败");
        return new ResponseResult<>("Hello!");

    }


}
