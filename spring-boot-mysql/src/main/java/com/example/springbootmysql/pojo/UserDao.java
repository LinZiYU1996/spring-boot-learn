package com.example.springbootmysql.pojo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUserName(String name);

    User findByUserNameOrPassword(String username, String password);

    List<User> findAllByIdIsIn(List<Long> longList);
}
