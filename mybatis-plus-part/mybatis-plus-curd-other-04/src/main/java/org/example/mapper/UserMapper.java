package org.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;

/**
 * mybatis: 1. mapper接口 curd方法 2. mapperxml crud sql语句
 * mybatis-plus: 1. mapper接口 extends Base Mapper 2 . curd方法 curd的sql
 */
public interface UserMapper extends BaseMapper<User> {

    // 定义一个根据年龄参数查询，并且分页方法
    IPage<User> queryByAge(IPage<User> page, @Param("age") Integer age);

}
