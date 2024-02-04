package org.example.api;


import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiController {


    @Autowired // ioc容器中获取对应类型的实体对象（组件） 并自动装配
    private ServletContext servletContext;

    public void data(HttpServlet httpServlet, HttpServletResponse httpServletResponse,
                     HttpServletRequest httpServletRequest,
                     HttpSession httpSession
                     ){



        // 使用原生对象
        // ServletContext [1. 最大配置文件 2.全局最大共享域 3. 核心api getRealPath]
        // 方案1 ： request获取session对象
        ServletContext servletContext = httpServletRequest.getServletContext();
        ServletContext servletContext1 = httpSession.getServletContext();

        // 方案2：ServletContext 会自动装配到Ioc容器中，程序启动ServletContext - ioc容器
        // 直接全局注入


    }

}
