package com.baizhi.kyh.interceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new URLInterceptor()).excludePathPatterns("/admin/checkLogin","/","/kaptcha/*").addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
