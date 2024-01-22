package org.example.mapper;

import org.example.pojo.Employee;

public interface EmployeeMapper {

    // 根据id查询员工信息

    Employee queryById(Integer id);

    int deleteById(Integer id);
}
