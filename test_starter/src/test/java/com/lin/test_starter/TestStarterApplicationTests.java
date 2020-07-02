package com.lin.test_starter;

import com.lin.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestStarterApplicationTests {



    @Autowired
    HelloService helloService;
    @Test
    public void contextLoads() {
        System.out.println(helloService.sayHello());
    }


}
