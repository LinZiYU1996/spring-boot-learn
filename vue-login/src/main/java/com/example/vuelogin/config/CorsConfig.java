package com.example.vuelogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/6
 * \* Time: 19:50
 * \* Description:
 * 这里有一个跨域问题，即 Vue 使用 8080 端口，要
 * 访问 8088 端口的服务器，会报错。错误信息如下：
 * 这个问题在 Vue 端或在 Springboot 端处理都可以，
 * 我在 Springboot 端处理的，写一个 CorsConfig 类内容如下，不
 * 要忘了 @Configuration 注解。
 * \
 */


@Configuration
public class CorsConfig {

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1
        corsConfiguration.addAllowedHeader("*"); // 2
        corsConfiguration.addAllowedMethod("*"); // 3
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }



}
