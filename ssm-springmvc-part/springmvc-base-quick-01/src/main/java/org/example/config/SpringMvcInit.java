package org.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 可以被web项目加载，会初始化ioc容器，会设置dispactcherServlet的地址
 * 该类的目的是替代web.xml文件
 */
public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {


    // 创建service mapper层的ioc容器配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // 设置我们项目相应的配置 sparingmvc conrtroller
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    // 配置springmvc内部自带的servlet的访问地址
    // Dipatcher拦截路径  / 代表所有
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
