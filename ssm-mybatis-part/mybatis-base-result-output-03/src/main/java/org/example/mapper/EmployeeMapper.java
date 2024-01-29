package org.example.mapper;

import org.example.pojo.Employee;

import java.util.Map;

public interface EmployeeMapper {

    // 如果是dml语句 （插入 修改 删除）
    int deleteById(Integer id);

    // 指定输出类型 查询语句
    // 根据员工的id查询员工的姓名
    String queryNameById(Integer id);


    // 根据员工id查询员工工资
    Double querySalaryById(Integer id);

    // 返回单个实体类型

    Employee queryById(Integer id);


    /**
     * 查询部门的最高工资和平均工资
     * @return
     */
    Map<String,Object> selectEmpNameAndMaxSalary();
}
