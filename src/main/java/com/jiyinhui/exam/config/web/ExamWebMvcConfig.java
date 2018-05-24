package com.jiyinhui.exam.config.web;

import com.jiyinhui.exam.config.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ExamWebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/**")
                .excludePathPatterns("/toLogin", "/login", "/toRegist", "/user/toNewPassword", "/toForget","/email/send"
                ,"/verify", "/user/password/modify", "/regist");
    }
}
