package com.lin.aop_data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.lin.aop_data.mapper")
public class AopDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopDataApplication.class, args);
    }

}
