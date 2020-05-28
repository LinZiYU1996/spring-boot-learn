package com.example.springbootshiro.controller;

import com.example.springbootshiro.common.dto.ResponseCode;
import com.example.springbootshiro.common.enums.StatusEnums;
import com.example.springbootshiro.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import static org.apache.shiro.util.ThreadContext.getSubject;


/**
 * @program: spring-boot-20-shiro
 * @description: 登录
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-14 11:51
 */
@RestController
@Slf4j
public class LoginController {

    /**
     * 登录操作
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseCode login(@RequestBody User user) {
        Subject userSubject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassword());
        log.info(user.getAccount() + " ***"+user.getPassword());
        try {
            // 登录验证
            userSubject.login(token);
            return ResponseCode.success();
        } catch (UnknownAccountException e) {
            return ResponseCode.error(StatusEnums.ACCOUNT_UNKNOWN);
        } catch (DisabledAccountException e) {
            return ResponseCode.error(StatusEnums.ACCOUNT_IS_DISABLED);
        } catch (IncorrectCredentialsException e) {
            return ResponseCode.error(StatusEnums.INCORRECT_CREDENTIALS);
        } catch (Throwable e) {
            e.printStackTrace();
            return ResponseCode.error(StatusEnums.SYSTEM_ERROR);
        }
    }


    @RequestMapping(value = "/login1", method = RequestMethod.POST)
    @ResponseBody
    public ResponseCode login1(@RequestParam("account") String accout,@RequestParam("password") String password) {
        Subject userSubject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(accout, password);
        log.info(" ***");
        try {
            // 登录验证
            userSubject.login(token);
            return ResponseCode.success();
        } catch (UnknownAccountException e) {
            return ResponseCode.error(StatusEnums.ACCOUNT_UNKNOWN);
        } catch (DisabledAccountException e) {
            return ResponseCode.error(StatusEnums.ACCOUNT_IS_DISABLED);
        } catch (IncorrectCredentialsException e) {
            return ResponseCode.error(StatusEnums.INCORRECT_CREDENTIALS);
        } catch (Throwable e) {
            e.printStackTrace();
            return ResponseCode.error(StatusEnums.SYSTEM_ERROR);
        }
    }



    @GetMapping("/login")
    public ResponseCode login() {
        return ResponseCode.error(StatusEnums.NOT_LOGIN_IN);
    }

    @GetMapping("/auth")
    public String auth() {
        return "已成功登录";
    }

    @GetMapping("/role")
    @RequiresRoles("vip")
    public String role() {
        return "测试Vip角色";
    }

    @GetMapping("/permission")
    @RequiresPermissions(value = {"add", "update"}, logical = Logical.AND)
    public String permission() {
        return "测试Add和Update权限";
    }

    /**
     * 登出
     * @return
     */
    @GetMapping("/logout")
    public ResponseCode logout() {
        getSubject().logout();
        return ResponseCode.success();
    }
}