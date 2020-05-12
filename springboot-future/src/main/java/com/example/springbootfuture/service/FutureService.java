package com.example.springbootfuture.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 20:05
 * \* Description:
 * \
 */

@Service

public class FutureService {

    @Async
    public Future<String> futureTest() throws InterruptedException {
        System.out.println("任务执行开始,需要：" + 1000 + "ms");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println("do:" + i);
        }
        System.out.println("完成任务");
        return new AsyncResult<>(Thread.currentThread().getName());
    }
}
