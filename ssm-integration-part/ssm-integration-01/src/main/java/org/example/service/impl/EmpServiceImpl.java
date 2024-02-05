package org.example.service.impl;

import org.example.mapper.EmployeeMapper;
import org.example.pojo.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements EmployeeService {

    @Autowired
    // todo 20240205 这里虽然报错，但是不影响运行
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findALl() {
        List<Employee> employees =  employeeMapper.queryList();
        return employees;
    }
}
