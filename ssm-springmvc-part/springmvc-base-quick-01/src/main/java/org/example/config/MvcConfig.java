package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 *  1. 将contaoller配置ioc容器
 *  2. handlerMapping handlerAdopter加入到ioc容器
 */
@Configuration
@ComponentScan("org.example.controller")
public class MvcConfig {


    @Bean
    public  RequestMappingHandlerMapping handlerMapping(){
        return new RequestMappingHandlerMapping();
    }


    @Bean
    public RequestMappingHandlerAdapter handlerAdapter(){
        return new RequestMappingHandlerAdapter();
    }

}
