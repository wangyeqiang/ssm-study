package org.example.service;

import org.example.pojo.Student;

import java.util.List;

public interface StudentService {

    /**
     * 查询所有学院数据业务
     * @return
     */
    List<Student> findall();
}
