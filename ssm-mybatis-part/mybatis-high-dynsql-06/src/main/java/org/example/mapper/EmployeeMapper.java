package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    // 根据员工的姓名和工资查询员工的信息

    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);

}
