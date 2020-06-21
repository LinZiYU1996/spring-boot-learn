package com.lin.aop2.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/20
 * \* Time: 16:35
 * \* Description:
 * \
 */
@Aspect
@Component
public class Audience3 {
//向通知方法中传递被通知方法的参数：

    private Map<String, Integer> playedTimes = new HashMap<>();

    /**
     * 参数为String的方法
     * @param pianist 被通知方法的中的名为"pianist"的参数
     */
    @Pointcut("execution(* com.lin.aop2.pointcut.Performence.play(String))"
            + "&& args(pianist)")
    public void performance(String pianist){}

    /**
     * 前置通知
     * @param pianist 被通知方法的中的名为"pianist"的参数
     */
    @Before("performance(pianist)")
    public void updateTimes(String pianist){
        System.out.println(pianist + "：");
        int currentCount = getPlayCount(pianist);

        playedTimes.put(pianist, currentCount + 1);
    }

    /**
     * 演奏次数统计
     * @param pianist
     * @return
     */
    public int getPlayCount(String pianist){
        return playedTimes.containsKey(pianist) ? playedTimes.get(pianist) : 0;
    }
}
