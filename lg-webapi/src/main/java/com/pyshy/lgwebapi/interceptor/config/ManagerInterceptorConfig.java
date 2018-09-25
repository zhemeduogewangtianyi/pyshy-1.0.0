package com.pyshy.lgwebapi.interceptor.config;

import com.pyshy.lgwebapi.interceptor.BeforeViewHandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ManagerInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截

        registry.addInterceptor(new BeforeViewHandlerInterceptor()).addPathPatterns("/**");

//        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");

        WebMvcConfigurer.super.addInterceptors(registry);

    }
}
