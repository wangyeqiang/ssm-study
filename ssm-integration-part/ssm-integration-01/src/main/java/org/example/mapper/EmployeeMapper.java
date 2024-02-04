package org.example.mapper;

import org.example.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeMapper {

    // 查询全部员工信息
    List<Employee> queryList();
}
