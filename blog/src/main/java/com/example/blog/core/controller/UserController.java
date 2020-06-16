package com.example.blog.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.blog.common.component.Result;
import com.example.blog.common.utils.ShiroUtils;
import com.example.blog.core.entity.VblogUser;
import com.example.blog.core.service.IVblogUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/14
 * \* Time: 11:42
 * \* Description:
 * \
 */

@RestController
@RequestMapping("/user")
@CrossOrigin
@Slf4j
public class UserController {

    @Autowired
    private IVblogUserService userService;


    @GetMapping("/current")
    public Result getCurrentUser(HttpServletRequest request) {

        log.info("user  current ");
        VblogUser userEntity = ShiroUtils.getUserEntity();

        JSONObject object = new JSONObject();
        object.put("account", userEntity.getAccount());
        object.put("nickname", userEntity.getNickname());
        object.put("avatar", userEntity.getAvatar());
        object.put("id", userEntity.getId());

        return Result.ok(object);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id){
        VblogUser user = userService.selectById(id);

        return Result.ok().put("user", user);
    }


}
