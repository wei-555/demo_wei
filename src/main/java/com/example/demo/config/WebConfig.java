package com.example.demo.config;

import com.example.demo.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wyl
 * @create 2021-07-13 17:07
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @SuppressWarnings("unused")
    @Autowired
    private TimeInterceptor timeInterceptor;

    // 拦截器的一个注册器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor).addPathPatterns("/**").excludePathPatterns(
                "info",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js"
        );
    }

}
