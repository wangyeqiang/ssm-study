package org.example.controller;


import org.example.pojo.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    @Autowired // 如果该接口只有一个实现类，就可以直接用，如果有多个实现类 就要用@Qualifier
    @Qualifier("StudentServiceImpl") // 指定类实例
    private StudentService studentService;

    public void findAll(){
        List<Student> all = studentService.findAll();
        System.out.println("all = " + all);
    }
}
