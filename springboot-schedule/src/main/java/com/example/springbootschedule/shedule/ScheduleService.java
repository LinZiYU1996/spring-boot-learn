package com.example.springbootschedule.shedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 20:26
 * \* Description:
 * \
 */

@Service

public class ScheduleService {

    @Scheduled(fixedDelay = 2000)
    public void scheduleTest1() throws InterruptedException {
        System.out.println("scheduleTest1 Start.>>" + new Date().toLocaleString());
        Thread.sleep(6000);
        System.out.println("scheduleTest1 End.>>" + new Date().toLocaleString());
    }

    @Scheduled(fixedRate = 2000)
    public void scheduleTest2() throws InterruptedException {
        System.out.println("scheduleTest2 Start.>>" + new Date().toLocaleString());
        Thread.sleep(6000);
        System.out.println("scheduleTest2  End.>>");
    }

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void scheduleTest3() {
        System.out.println("scheduleTest3 >>>");
    }

    @Scheduled(fixedRate = 2000, initialDelay = 1000)
    public void scheduleTest4() throws InterruptedException {
        System.out.println("scheduleTest2 fixedRate Start.>>");
        Thread.sleep(6000);
        System.out.println("scheduleTest2 fixedRate End.>>");
    }

}
