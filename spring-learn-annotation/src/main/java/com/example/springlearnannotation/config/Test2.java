package com.example.springlearnannotation.config;

import com.example.springlearnannotation.pojo.definition.BusinessPerson;
import com.example.springlearnannotation.pojo.definition.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/9
 * \* Time: 16:28
 * \* Description:
 * \
 */
public class Test2 {

    public static void main(String[] args) {


        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);

        Person person = ctx.getBean(BusinessPerson.class);
        person.service();
    }
}
