package com.example.springbootevent;

import com.example.springbootevent.publisher.DemoPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootEventApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private DemoPublisher demoPublisher;

    @Test
    public void publisherTest() {
        demoPublisher.publish(1L, "成功了！");
    }


    /*
    >>>>>>>>>DemoListener2>>>>>>>>>>>>>>>>>>>>>>>>>>>>
收到了：com.example.springbootevent.publisher.DemoPublisher@5ed190be消息;时间：1589100836850
消息：1:成功了！
>>>>>>>>>DemoListener>>>>>>>>>>>>>>>>>>>>>>>>>>>>
收到了：com.example.springbootevent.publisher.DemoPublisher@5ed190be消息;时间：1589100836850
消息：1:成功了！
     */
}
