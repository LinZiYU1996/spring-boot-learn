package com.example.springlearnannotation.pojo.definition;

import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/9
 * \* Time: 16:27
 * \* Description:
 * \
 */

@Component
public class Dog implements Animal{

    @Override
    public void use() {
        System.out.println("狗 { " +
                Dog.class.getSimpleName()+
                "} 看门");
    }
}
