package org.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringIocInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    // root ioc容器配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DataSourceConfig.class, MapperJavaConfigNew.class, ServiceJavaConfig.class};
    }


    // web ioc容器配置指定
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcJavaConfig.class};
    }


    // dispatcher拦截路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
