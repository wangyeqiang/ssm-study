package org.example.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 1. controller
 * 2. 全局异常处理
 * 3. handlerMapping handlerAdatper
 * 4. 静态处理器
 * 5. jsp视图解析器前后缀
 * 6. json转化器
 * 7. 拦截器
 */


@Configuration
@ComponentScan("org.example.controller")   // 这里的扫描包还是要添加的
@EnableWebMvc  // handlerMapping handlerAdatper json转化器
public class WebMvcJavaConfig implements WebMvcConfigurer {


    @Override  // 开启静态资源处理
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/","jsp");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new xx.addPath);
    }

}
