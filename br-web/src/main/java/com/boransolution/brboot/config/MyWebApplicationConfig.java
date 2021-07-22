package com.boransolution.brboot.config;

import com.boransolution.brboot.util.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebApplicationConfig implements WebMvcConfigurer {    // 定义MVC配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {    // 进行拦截器的注册处理操作
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");    // 匹配路径
    }
}