package com.example.vuelogin.controller;

import com.example.vuelogin.entity.User;
import com.example.vuelogin.msg.CommonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/6
 * \* Time: 19:53
 * \* Description:
 * \
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody User user) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("123456"))
            return CommonResult.success("admin");
        else
            return CommonResult.validateFailed();
    }
}
