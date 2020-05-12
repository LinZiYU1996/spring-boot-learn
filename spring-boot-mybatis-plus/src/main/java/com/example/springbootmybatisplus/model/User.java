package com.example.springbootmybatisplus.model;

import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/11
 * \* Time: 20:50
 * \* Description:
 * \
 */

@Data
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
