package com.lin.dynamic_data_source_jar;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 注意配置多数据源的时候一定要排除原生datasource干扰
 */


@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class DynamicDataSourceJarApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDataSourceJarApplication.class, args);
    }

}
