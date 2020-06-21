package com.lin.aop2;

import com.lin.aop2.config.ConcertConfig;
import com.lin.aop2.pointcut.Audience3;
import com.lin.aop2.pointcut.Performence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/20
 * \* Time: 16:35
 * \* Description:
 * \
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ConcertConfig.class})
public class TestAspect3 {

    @Resource(name="piano")
    Performence performence;

    @Autowired
    Audience3 audience3;

    @Test
    public void testPlayWithPianist(){
        performence.play("肖邦");
        performence.play("班得瑞");
        performence.play("宗次郎");
        performence.play("班得瑞");
        performence.play("班得瑞");
        performence.play("久石让");
        performence.play("雅尼");

        System.out.println("'班得瑞'演奏次数： " + audience3.getPlayCount("班得瑞"));

    }
}

