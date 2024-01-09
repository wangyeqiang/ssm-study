package org.example.Controller;

import org.example.pojo.Student;
import org.example.service.StudentService;

import java.util.List;

public class StudentController {


    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


    public void findAll() {
        List<Student> all = studentService.findall();
        System.out.println("最终学生数据位" + all);

    }
}
