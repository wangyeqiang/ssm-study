package org.example.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("org.example.json")
@EnableWebMvc
public class MvcConfig  implements WebMvcConfigurer {
    // handlerMapper handlerAdapter json转化器
    // 视图解析器 指定前后缀

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        // registry 可以快速加前后缀
        registry.jsp("/WEB-INF/views/" ,".jsp");

        // hander -> index
    }


    // 开启静态资源查找
    // dispatcherServlet  -> handlerMapping 有没有对应的mapper -> 没有的话找静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
