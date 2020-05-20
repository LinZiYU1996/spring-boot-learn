package com.example.jwt.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/19
 * \* Time: 9:19
 * \* Description:
 * \
 */
public class GlobalWebMvcConfig implements WebMvcConfigurer {

    /**
     * 重写父类提供的跨域请求处理的接口
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 添加映射路径
        registry.addMapping("/**")
                // 放行哪些原始域
                .allowedOrigins("*")
                // 是否发送Cookie信息
                .allowCredentials(true)
                // 放行哪些原始域(请求方式)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS", "HEAD")
                // 放行哪些原始域(头部信息)
                .allowedHeaders("*")
                // 暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
                .exposedHeaders("Server","Content-Length", "Authorization", "Access-Token", "Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
    }


    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加权限拦截器
        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
    }





}
