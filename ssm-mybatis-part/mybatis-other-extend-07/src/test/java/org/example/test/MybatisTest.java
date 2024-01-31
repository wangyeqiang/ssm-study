package org.example.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @BeforeEach
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        session = sqlSessionFactory.openSession(true);
    }


    // 使用分页插件
    @Test
    public void test_01() throws IOException {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        // 再调用之前先设置分页数据（当前是第几页，以及每页显示多少个）

        // 后期前端会显示过来
        PageHelper.startPage(2, 2);
        //TODO:注意 不能将两条查询装到一个分页区
        List<Employee> list  = mapper.queryList();

        // 将查询数据封装到一个PageInfo的分页实体类中(一共有多少页，一共有多少条)
        PageInfo<Employee> pageInfo = new PageInfo<>(list);

        // // 当前页的数据
        List<Employee> list1 = pageInfo.getList();
        System.out.println("list1 = " + list1);
        // 获取总页数
        int pages = pageInfo.getPages();
        System.out.println("pages = " + pages);
        // 获取总条数
        long total = pageInfo.getTotal();
        System.out.println("total = " + total);
        int pageNum = pageInfo.getPageNum();
        System.out.println("pageNum = " + pageNum);
        int pageSize = pageInfo.getPageSize();
        System.out.println("pageSize = " + pageSize);


    }

    @AfterEach
    public void clean(){
        session.close();
    }



}
