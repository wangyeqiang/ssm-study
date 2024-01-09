package org.example;

import org.example.config.JavaConfigure;
import org.example.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIocTest {

    @Test
    public void  test() {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfigure.class);


        StudentController studentController = applicationContext.getBean(StudentController.class);

        studentController.findAll();

    }
}
