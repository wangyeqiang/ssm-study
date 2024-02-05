package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeMapper {

    // 查询全部员工信息
    List<Employee> queryList();
}
