//package com.lin.log_demo.controller;
//
//import com.lin.log_demo.model.TableName;
//import com.lin.log_demo.model.UserDO;
//import lombok.extern.java.Log;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
///**
// * \* Created with IntelliJ IDEA.
// * \* User: LinZiYu
// * \* Date: 2020/6/19
// * \* Time: 15:42
// * \* Description:
// * \
// */
//@RestController
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    /**
//     * 获取一位用户信息
//     *
//     * @param userId 用户id
//     * @return
//     */
//    @GetMapping("/user/{userId}")
//    public Map<String, Object> getByPrimaryKey(
//            @PathVariable("userId") Long userId) {
//        return userService.getByPrimaryKey(userId);
//    }
//
//    /**
//     * 修改一位用户信息
//     * @param userDO
//     * @param userId userId 用户id
//     * @return
//     */
//    @PutMapping("/user/{userId}")
//    @Log(table = TableNameEnum.USER,type = TypeNameEnum.UPDATE)
//    public Map<String, Object> updateByPrimaryKey(
//            @RequestBody UserDO userDO,
//            @PathVariable("userId") Long userId) {
//        userDO.setUserId(userId);
//        return userService.updateByPrimaryKey(userDO);
//    }
//
//    /**
//     * 删除一位用户信息
//     * @param userId userId 用户id
//     * @return
//     */
//    @DeleteMapping("/user/{userId}")
//    @Log(table = TableName.USER,type = TypeNameEnum.DELETE)
//    public Map<String, Object> deleteByPrimaryKey(
//            @PathVariable("userId") Long userId
//    ) {
//        return userService.deleteByPrimaryKey(userId);
//    }
//
//}
//
//
