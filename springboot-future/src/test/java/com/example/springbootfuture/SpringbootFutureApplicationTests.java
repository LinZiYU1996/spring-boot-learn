package com.example.springbootfuture;

import com.example.springbootfuture.service.AsyncService;
import com.example.springbootfuture.service.FutureService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootTest
class SpringbootFutureApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private AsyncService asyncService;

    @Test
    public void asyncTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            asyncService.executeAsync1();
            asyncService.executeAsync2();
        }
        Thread.sleep(1000);
    }

    /*
    异步任务::2
异步任务::2
异步任务::2
my-pool-3
my-pool-7
异步任务::2
my-pool-5
my-pool-1
异步任务::2
my-pool-4
异步任务::2
my-pool-2
异步任务::2
my-pool-6
my-pool-8
异步任务::1
异步任务::1
异步任务::1
异步任务::2
my-pool-4
异步任务::1
异步任务::1
异步任务::1
异步任务::2
my-pool-2
异步任务::2
异步任务::1
异步任务::1
异步任务::1
异步任务::1

     */


    @Resource
    private FutureService futureService;

    @Test
    public void futureTest() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        System.out.println("开始");
        Future<String> future = futureService.futureTest();
        //另外一个耗时任务
        Thread.sleep(500);
        System.out.println("另外一个耗时任务，需要500ms");

        String s = future.get();
        System.out.println("计算结果输出:" + s);
        System.out.println("共耗时：" + (System.currentTimeMillis() - start));
        Thread.sleep(5000);
    }

    /*
    开始
2020-05-10 20:06:22.147  INFO 21108 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService
任务执行开始,需要：1000ms
do:0
do:1
do:2
do:3
另外一个耗时任务，需要500ms
do:4
do:5
do:6
do:7
do:8
do:9
完成任务
计算结果输出:my-pool-1
共耗时：1023
     */

}
