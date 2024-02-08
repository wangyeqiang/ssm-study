package org.example.test;


import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusTableIdTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        User user = new User();
        user.setName("吕丹丹");
        user.setAge(20);
        user.setEmail("xxxx");

        // 主键不要赋值
        // 主键策略默认雪花算法（类似于UUID 只不过是Long类型）
        userMapper.insert(user);
    }


}
