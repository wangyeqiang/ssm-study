package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    // 根据员工的姓名和工资查询员工的信息

    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);


    List<Employee> queryTrim(@Param("name") String name, @Param("salary") Double salary);

    // 根据员工的ID更新员工数据，要求传入的name和salary部位null的才更新

    int update(Employee employee);


    int updateTrim(Employee employee);


    // 根据两个条件查询，如果姓名不为空则使用姓名查询，如果姓名为空但是薪水为空，则使用薪水查询，都为空查询全部
    List<Employee> queryChoose(@Param("name") String name, @Param("salary") Double salary);


    // 根据id批量查询
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);

    // 根据id批量删除
    int deleteBatch(@Param("ids") List<Integer> ids);

    // 根据id批量添加
    int insertBatch(@Param("list") List<Employee> employeeList);

    // 批量更新
    int updateBatch(@Param("list") List<Employee> employeeList);


}
