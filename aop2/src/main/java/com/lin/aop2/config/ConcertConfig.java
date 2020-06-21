package com.lin.aop2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/20
 * \* Time: 16:14
 * \* Description:
 * \
 */

//可以看出，这个类首先使用了@Configuration注解，
// 表明这个类属于一个配置类。然后使用@EnableAspectJAutoProxy
// 注解启用了AspectJ自动代理。最后是使用了@ComponentScan注解指定
// 需要扫描哪些包中的注解，这里配置的就是上面定义的Audience0类所在的包


@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages="com.lin.aop2.pointcut")
public class ConcertConfig {

}
