package com.example.springlearnannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringLearnAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnAnnotationApplication.class, args);
    }

}
