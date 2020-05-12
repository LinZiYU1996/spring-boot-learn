package com.example.springbootfuture.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 20:04
 * \* Description:
 * \
 */

@Service

public class AsyncService {

    @Async
    public void executeAsync1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(20);
        System.out.println("异步任务::1");

    }

    @Async
    public void executeAsync2() {
        System.out.println("异步任务::2");
    }

}
