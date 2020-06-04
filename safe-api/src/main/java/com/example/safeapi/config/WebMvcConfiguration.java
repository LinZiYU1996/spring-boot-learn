package com.example.safeapi.config;

import com.example.safeapi.token.NotRepeatSubmit;
import com.example.safeapi.token.TokenInfo;
import com.example.safeapi.util.ApiUtil;
import com.example.safeapi.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/3
 * \* Time: 19:30
 * \* Description:
 * \
 */

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport{

        private static final String[] excludePathPatterns  = {"/api/token/api_token"};

        @Autowired
        private TokenInterceptor tokenInterceptor;
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            super.addInterceptors(registry);
            registry.addInterceptor(tokenInterceptor)
                    .addPathPatterns("/api/**")
                    .excludePathPatterns(excludePathPatterns);
        }
}


