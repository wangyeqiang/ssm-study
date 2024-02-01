package org.example;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

public class Main implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // 每当web项目启动，就会自动调用该接口的onStartup
        System.out.println("Main.onStartup");

    }
}
