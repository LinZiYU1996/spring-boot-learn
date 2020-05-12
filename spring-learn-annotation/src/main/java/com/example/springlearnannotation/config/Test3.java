package com.example.springlearnannotation.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 9:23
 * \* Description:
 * \
 */
public class Test3 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctc = new AnnotationConfigApplicationContext(AppConfig1.class);

        ctc.close();


    }
}
