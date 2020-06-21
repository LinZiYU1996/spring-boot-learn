package com.lin.aop2;

import javax.annotation.Resource;

import com.lin.aop2.config.ConcertConfig;
import com.lin.aop2.pointcut.Performence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ConcertConfig.class})
public class TestAspect {

    @Resource(name="piano")
    Performence performence;

//    @Test
//    public void testPlay(){
//        performence.play();
//    }
//坐下
//保持安静
//开始演奏'The Rain'
//鼓掌


    @Test
    public void testPlay(){
        performence.play();
    }
}