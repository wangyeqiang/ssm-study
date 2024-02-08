package org.example.test;

import org.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusTableLogicTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void test1(){
        userMapper.deleteById(1);

        userMapper.selectList(null);
    }
}
