package org.example.dao;

import org.example.pojo.Student;

import java.util.List;

public interface StudentDao {

    List<Student> queryAll();

    void updateNameById(String name,Integer id);

    void updateAgeById(Integer age,Integer id);

}
