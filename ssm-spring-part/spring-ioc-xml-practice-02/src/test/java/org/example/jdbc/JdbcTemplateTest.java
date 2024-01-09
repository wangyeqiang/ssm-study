package org.example.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.example.Controller.StudentController;
import org.example.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateTest {
    public void testForJava() {
        /**
         * 简化数据库的CRUD，不提供连接池
         * DruidDataSource负责链接库的创建和数据库驱动的注册
         */
        // 0.创建连接池对象
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://stub");
        druidDataSource.setDriverClassName("com.jdbc.cj.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        // 1. 实例化对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource);
        // 2. 调用方法即可
        // jdbcTemplate.update("");  // DDL DML DCL
        // jdbcTemplate.queryForObject(""); DQL查询单个对象
        // jdbcTemplate.query(""); DQL查询集合
    }

    /**
     * 通过IOC容器读取配置的jdbctemplate组件
     */
    @Test
    public void testForIoc() {
        // 1. 创建ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        // 2 .获取templcate组件
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        // 3. 进行数据的插入、删除、修改update
        String sql = "insert into students (id,name,gender,age,class) values (?,?,?,?,?)";
        /**
         * 参数1 sql语句 可以带占位符，只能替代值
         * 参数2 Object。。。param参数 传入占位符的值 顺序 操作至右开始
         * 返回值 int 硬性函数
         */
        int rows = jdbcTemplate.update(sql,10,"三狗子","男",18,"三年二班");
        System.out.println("rows=" + rows);


        // 3.2 查询单条数据
        sql = "select * from students where id = ?";
        /**
         * 参数1 SQL语句
         * 参数2 RowMapper 列名和属性名的映射接口
         * 参数3 Object...param 占位符的值
         * 返回值 RowMapper的返回对象
         */
        Student student1 = jdbcTemplate.queryForObject(sql,  (rs, rowNum) ->  {
                // rs 结果集
                // rowNum是行数 不用关注
                // rs 结果集 获取列的值 赋值给实体类即可
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));
                student.setClasses(rs.getString("class"));
                return student;
        },1);
        System.out.println("student" + student1);


        // 3.3 查询所有学生数据
        sql = "select  id,name,age,gender ,class as classes from students";

        //TODO BeanPropertyRowMapper 帮助我们自动映射列和属性值 要求列名和属性名一致
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("studentList = " + studentList);


    }


    /**
     * 从IOC容器中 获取controller并且调用业务，内部都是ioc容器进行组装
     */
    @Test
    public void testQueryAll() {
        //1. 创建IOC容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");

        //2. 获取组件对象
        StudentController controller = applicationContext.getBean(StudentController.class);

        //3. 使用组件对象
        controller.findAll();

        //4. 关闭容器
        applicationContext.close();

    }
}
