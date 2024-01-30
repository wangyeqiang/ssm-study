package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {

    private SqlSession sqlSession;

    @BeforeEach  // 每次走测试方法之前，先走初始化方法
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        sqlSession = sqlSessionFactory.openSession(true);
    }

    @AfterEach  // 每次走测试方法之后，调用的方法
    public void clean(){
        sqlSession.close();
    }



    @Test
    public void testInsert() throws IOException {

        // 1. 读取输入流
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("root");
        user.setPassword("123456");
        int insert = mapper.insert(user);
        System.out.println("insert = " + insert);

    }


    @Test
    public void testUpdate(){
        // 1. 读取输入流
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setUsername("root");
        user.setPassword("123456");
        int update = mapper.update(user);
        System.out.println("update = " + update);
    }


    @Test
    public void testDelete(){

        // 1. 读取输入流
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int delete = mapper.delete(1);
        System.out.println("delete = " + delete);

    }


    @Test
    public void testSelectById(){

    }


    @Test
    public void testSelectAll(){

    }
}
