package com.lin.http_aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@ComponentScan("com.lin.http_aop.utils")
public class HttpAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpAopApplication.class, args);
    }

}
