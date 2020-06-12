package com.example.login.controller;

import com.example.login.entity.User;
import com.example.login.util.Msg;
import com.example.login.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/8
 * \* Time: 10:11
 * \* Description:
 * \
 */

@RestController
@CrossOrigin
public class Account {

//
//    @PostMapping("/login")
//    public  Map<String,Object> login(@RequestBody User user) {
//
//        System.out.println(user.getUsername() + "{}" + user.getPassword());
//        Map<String,Object> map = new HashMap<>(6) ;
//        if("123".equals(user.getUsername())&&"123".equals(user.getPassword())){
//            map.put("flag",true) ;
//            map.put("code", 200);
//            map.put("msg","登录成功") ;
//            map.put("token", 123);
//            return map ;
//        }
//        map.put("flag","false") ;
//        map.put("msg","用户名或密码错误") ;
//        return map ;
//    }



    /*

    js


      console.log(res.data.code+"{}");
        console.log(res.data.msg+"{}");
        console.log(res.data.data.token+"{}");



     */

    @PostMapping("/login")
    public  Result login(@RequestBody User user) {

        System.out.println(user.getUsername() + "{}" + user.getPassword());
        Map<String,Object> map = new HashMap<>(6) ;
        Result result;
        if("123".equals(user.getUsername())&&"123".equals(user.getPassword())){
             result = Result.succ(map);
            map.put("token", 123);
            map.put("flag","false") ;
            map.put("msg","用户名或密码错误") ;
            return result ;
        }
        map.put("flag","false") ;
        map.put("msg","用户名或密码错误") ;
        result = Result.error(map);
        return result;
    }

    @GetMapping("/g")
    public Result getMsg() {

        Map<String,Object> map = new HashMap<>(6) ;
        Result result = Result.succ(map);
        map.put("token", 123);
        map.put("flag","false") ;
        map.put("msg","用户名或密码错误") ;
        return result;

    }

}
