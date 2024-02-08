package org.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.pojo.User;

/**
 * mybatis: 1. mapper接口 curd方法 2. mapperxml crud sql语句
 * mybatis-plus: 1. mapper接口 extends Base Mapper 2 . curd方法 curd的sql
 */
public interface UserMapper extends BaseMapper<User> {
}
