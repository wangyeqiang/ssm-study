package org.example.config;


import org.example.interceptor.MyInterceptor;
import org.example.interceptor.MyInterceptor1;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan({"org.example.controller","org.example.error"})
@EnableWebMvc
public class MvcConfig  implements WebMvcConfigurer {
    // handlerMapper handlerAdapter json转化器
    // 视图解析器 指定前后缀


    // 开启静态资源查找
    // dispatcherServlet  -> handlerMapping 有没有对应的mapper -> 没有的话找静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置方案1： 代表拦截全部请求
//        registry.addInterceptor(new MyInterceptor());

        // 配置方案2： 指定地址拦截
        // * 代表任意一层字符串
        // ** 代表任意多层字符串
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user/**");

        // 配置方案3：排除拦截
        // 排除的地址 应该在拦截地址内部
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user/**").excludePathPatterns("/user/data1");

        registry.addInterceptor(new MyInterceptor());
        registry.addInterceptor(new MyInterceptor1());

    }
}
