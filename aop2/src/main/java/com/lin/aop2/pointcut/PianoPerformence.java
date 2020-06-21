package com.lin.aop2.pointcut;

import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/20
 * \* Time: 16:12
 * \* Description:
 * \
 */

@Component("piano")
public class PianoPerformence implements Performence{


    @Override
    public void play() {
        System.out.println("开始演奏'The Rain'");
        try {
            Thread.sleep(2000);  //模拟演奏
//			throw new RuntimeException("测试");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void play(String pianist) {
        if(pianist != null){
            System.out.println(pianist + " -->开始演奏");
        }else{
            System.out.println("开始演奏");
        }
    }



}
