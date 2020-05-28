package com.example.shiro.database;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserService {

    public UserBean getUser(String username) {
        // 没有此用户直接返回null
        System.out.println(username);
        for (String s :DataSource.getData().keySet()) {
            System.out.println(s + "=== " + DataSource.getData().get(s));
        }
        if (! DataSource.getData().containsKey(username))
            return null;

        UserBean user = new UserBean();
        Map<String, String> detail = DataSource.getData().get(username);

        user.setUsername(username);
        user.setPassword(detail.get("password"));
        user.setRole(detail.get("role"));
        user.setPermission(detail.get("permission"));
        return user;
    }
}
