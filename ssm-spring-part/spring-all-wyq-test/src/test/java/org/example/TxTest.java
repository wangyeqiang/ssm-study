package org.example;

import org.example.config.JavaConfigure;
import org.example.service.tx.StudentService;
import org.example.service.tx.TopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

@SpringJUnitConfig(JavaConfigure.class)
public class TxTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TopService topService;

    @Test
    public void test(){

//        try {
//            studentService.changeInfo();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        topService.topService();

    }

}
