package com.example.springlearnannotation.scope.pojo;

import com.example.springlearnannotation.scope.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 9:29
 * \* Description:
 * \
 */
public class T {

    /*
    验证默认创建的bean 为单例模式
     */
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx

                = new AnnotationConfigApplicationContext(AppConfig.class);

        ScopeBean scopeBean1 = ctx.getBean(ScopeBean.class);
        ScopeBean scopeBean2 = ctx.getBean(ScopeBean.class);
        System.out.println(scopeBean1 == scopeBean2);
    }
}
