package com.zyp.springboot04web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    public void addViewController(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
       registry.addViewController("/index.html").setViewName("index");
       registry.addViewController("/main.html").setViewName("dashboard");
    }
    //自定义国际化组件
    @Bean("localeResolver")
    public LocaleResolver localeResolver(){
        return new MylocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHanderInterceptor()).addPathPatterns("/**").excludePathPatterns("/index","/","/user/login","/css/*","/js/**","/img/**");
    }
}
