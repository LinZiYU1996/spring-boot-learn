package com.lin.mymatis_plus_p6spy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.mymatis_plus_p6spy.mapper")
public class MymatisPlusP6spyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymatisPlusP6spyApplication.class, args);
    }

}
