package com.lin.http_aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/28
 * \* Time: 9:16
 * \* Description:
 * \
 */

@RestController
@RequestMapping
public class Hello {


    @RequestMapping(value = "/he", method = {RequestMethod.GET})
    public String hello(){
        return "hello";
    }

    @GetMapping(value = "/t")
    public Map<String, String> test() {
        Map<String, String> has = new HashMap<>();

        has.put("a","a");

        return has;
    }


}
