package org.example.test;

import org.example.config.JavaConfig;
import org.example.service.StudentService;
import org.example.service.TopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

@SpringJUnitConfig(JavaConfig.class)
public class SpringTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TopService topService;

    @Test
    public  void test() throws FileNotFoundException {
//        studentService.changeInfo();
        topService.topService();

    }


}
