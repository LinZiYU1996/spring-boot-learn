package com.example.blog.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.blog.common.component.Result;
import com.example.blog.common.constant.Constant;
import com.example.blog.core.entity.VblogUser;
import com.example.blog.core.service.IVblogUserService;
import com.example.blog.core.service.IVblogUserTokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.PrinterURI;
import java.io.IOException;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/14
 * \* Time: 11:17
 * \* Description:
 * \
 */

@Slf4j
@RestController
@CrossOrigin
public class LoginController {


    @Autowired
    private IVblogUserService userService;


    @Autowired
    private IVblogUserTokenService userTokenService;




    // 用户登录(不带验证码)
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody JSONObject json) throws IOException {
        log.info(" LoginController  login ");
        String account = json.getString("account");
        String password = json.getString("password");
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return Result.error("参数不对");
        }

        //用户信息
        VblogUser user = userService.queryByUserAccount(account);

        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
            return Result.error("账号或密码不正确");
        }

        //账号锁定
        if (Constant.UserStatus.PAUSE.getValue().equals(user.getStatus())) {
            return Result.error("账号已被锁定,请联系管理员");
        }

        //生成token，并保存到数据库
        Result r = userTokenService.createToken(user.getId());
        return r;
    }
}
