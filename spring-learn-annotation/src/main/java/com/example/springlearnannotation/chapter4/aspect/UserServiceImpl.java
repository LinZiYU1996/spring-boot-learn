package com.example.springlearnannotation.chapter4.aspect;

import com.example.springlearnannotation.chapter4.pojo.User;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 10:32
 * \* Description:
 * \
 */
public class UserServiceImpl implements UserService{

    @Override
    public void printU(User user) {
        if (user == null) {
            throw new RuntimeException("null");
        }


        System.out.println("id ==" + user.getId());

        System.out.println("name == " + user.getName());

        System.out.println("note == " + user.getNote());

    }
}
