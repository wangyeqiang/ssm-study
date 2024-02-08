package org.example.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;

import org.example.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author WYQ
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-02-08 16:54:00
* @Entity org.example.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {

    // 批量插入
    int insertBatch(@Param("userCollection") Collection<User> userCollection);

    // 查询
    List<User> selectByNameAndAge(@Param("name") String name, @Param("age") Integer age);
}




