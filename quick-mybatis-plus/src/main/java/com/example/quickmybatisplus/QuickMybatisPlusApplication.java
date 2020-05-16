package com.example.quickmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.quickmybatisplus.mapper")
public class QuickMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickMybatisPlusApplication.class, args);
    }

}
