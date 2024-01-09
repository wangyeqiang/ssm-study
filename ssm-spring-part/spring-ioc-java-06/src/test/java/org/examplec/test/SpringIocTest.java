package org.examplec.test;

import org.example.config.JavaConfiguration;
import org.example.config.JavaConfigurationA;
import org.example.config.JavaConfigurationB;
import org.example.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.format.datetime.standard.Jsr310DateTimeFormatAnnotationFormatterFactory;

public class SpringIocTest {
    @Test
    public void test(){


        // 1. 创建IOC容器，之前是通过xml文件创建的
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);


        // 2. 获取bean对象
        StudentController studentController = applicationContext.getBean(StudentController.class);

        System.out.println("studentController = " + studentController);

    }


    public void test04() {
        ApplicationContext applicationContext  = new AnnotationConfigApplicationContext(JavaConfigurationA.class);
    }
}
