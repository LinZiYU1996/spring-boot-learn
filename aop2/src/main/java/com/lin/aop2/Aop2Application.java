package com.lin.aop2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.lin.aop2.pointcut")
public class Aop2Application {

    public static void main(String[] args) {
        SpringApplication.run(Aop2Application.class, args);
    }

}
