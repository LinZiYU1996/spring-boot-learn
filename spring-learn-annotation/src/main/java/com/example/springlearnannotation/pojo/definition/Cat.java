package com.example.springlearnannotation.pojo.definition;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 9:06
 * \* Description:
 * \
 */
public class Cat implements Animal{

    @Override
    public void use() {
        System.out.println("猫 {"
        +Cat.class.getSimpleName()
        +" 抓老鼠}");
    }
}
