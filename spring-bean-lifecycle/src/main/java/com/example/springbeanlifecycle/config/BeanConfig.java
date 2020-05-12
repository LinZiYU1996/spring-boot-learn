package com.example.springbeanlifecycle.config;

import com.example.springbeanlifecycle.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 16:44
 * \* Description:
 * \
 */

@Configuration

public class BeanConfig {

    @Bean(initMethod = "myInit", destroyMethod = "myDestroy")
    public User user() {
        return new User();
    }


}
