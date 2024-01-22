package org.example;


import org.example.config.JavaConfigure;
import org.example.controller.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest {

    @org.junit.jupiter.api.Test
    public void Test2(){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfigure.class);

        StudentController studentController = applicationContext.getBean(StudentController.class);

        studentController.findAll();
    }
}
