package org.example.dao.Impl;

import org.example.dao.StudentDao;
import org.example.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    // 注入JDBC的template对象
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> queryAll() {
        // jdbcTemplate进行数据库的查询，ioc进行装配，不要自己实例化
        String sql = "select id,name,gender,age,class as classess from studb.students";
        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println("studentsDao" + students);
        return students;
    }
}
