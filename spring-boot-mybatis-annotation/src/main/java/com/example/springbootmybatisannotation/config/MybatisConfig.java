//package com.example.springbootmybatisannotation.config;
//
///**
// * \* Created with IntelliJ IDEA.
// * \* User: LinZiYu
// * \* Date: 2020/5/11
// * \* Time: 21:09
// * \* Description:
// * \
// */
//
//
//import org.apache.ibatis.mapping.DatabaseIdProvider;
//import org.apache.ibatis.mapping.Environment;
//import org.mybatis.spring.annotation.MapperScan;
//import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.DefaultResourceLoader;
//import org.springframework.core.io.ResourceLoader;
//
//@Configuration
//@MapperScan("com.example.springbootmybatisannotation.mapper")
//public class MybatisConfig {
//
//    @Autowired
//    private Environment environment;
//    private RelaxedPropertyResolver propertyResolver;
//    @Autowired
//    private DataSource dataSource;
//    @Autowired
//    private MybatisProperties properties;
//    @Autowired
//    private ResourceLoader resourceLoader = new DefaultResourceLoader();
//    @Autowired(required = false)
//    private Interceptor[] interceptors;
//    @Autowired(required = false)
//    private DatabaseIdProvider databaseIdProvider;
//
//}
