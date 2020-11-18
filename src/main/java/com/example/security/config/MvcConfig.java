package com.example.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: wxy
 * @Date: 2020/11/17
 * @Description:
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 配置mvc视图
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/").setViewName("home.html");
        registry.addViewController("/home").setViewName("home.html");
        registry.addViewController("/hello").setViewName("hello.html");
    }
}
