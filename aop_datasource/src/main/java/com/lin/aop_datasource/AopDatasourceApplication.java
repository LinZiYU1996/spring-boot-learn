package com.lin.aop_datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.example.demo.mapper")
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})

public class AopDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopDatasourceApplication.class, args);
    }

}
