package com.example.springbootfuture.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 20:04
 * \* Description:
 * \
 */

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //核心线程数
        taskExecutor.setCorePoolSize(8);
        //最大线程数
        taskExecutor.setMaxPoolSize(16);
        //队列大小
        taskExecutor.setQueueCapacity(100);
        taskExecutor.setThreadNamePrefix("my-pool-");
        taskExecutor.initialize();
        return taskExecutor;
    }
}

//springboot 配置多线程需要两个注解
//
//@EnableAsync
//在配置类中通过加@EnableAsync开启对异步任务的支持
//@Async
//在需要执行的方法上加@Async表明该方法是个异步方法，如果加在类级别上，则表明类所有的方法都是异步方法


