package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.EmployeeMapper;
import org.example.pojo.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    private SqlSession session;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    // @BeforeEach
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        session = sqlSessionFactory.openSession(true);
    }


    @Test
    public void test_01() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        session = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> query = mapper.query(null,101.0);
        System.out.println("query = " + query);



    }

    //@AfterEach
    public void clean(){
        session.close();
    }



}
