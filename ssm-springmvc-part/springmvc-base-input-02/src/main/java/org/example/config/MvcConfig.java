package org.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 项目的配置类，将controller,handlerMapping,handlerAdpater加入到ioc容器中
 */
@Configuration
@EnableWebMvc //handlerApdapter配置json转换器
              // 添加秘书、添加经理 同时给经理添加jackson的处理器
              // 添加了之后，下面的两个@Bean就不用写了
@ComponentScan("org.example.header")
public class MvcConfig {

//    @Bean
//    public RequestMappingHandlerMapping handlerMapping(){
//        return new RequestMappingHandlerMapping();
//    }
//
//
//    @Bean
//    public RequestMappingHandlerAdapter handlerAdapter(){
//        return new RequestMappingHandlerAdapter();
//    }
}
