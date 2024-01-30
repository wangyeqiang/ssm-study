package org.exampe.test;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.CustomerMapper;
import org.example.mapper.OrderMapper;
import org.example.pojo.Customer;
import org.example.pojo.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MybatisTest {


    private SqlSession session;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession(true);
    }


    @Test
    public void testToOne(){
        // 查询订单和用户
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Order order = mapper.queryOrderById(1);
        System.out.println(order);
        System.out.println(order.getCustomer());
    }

    @Test
    public void testToMany(){
        CustomerMapper mapper = session.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.queryList();
        System.out.println("customers = " + customers);

        for ( Customer customer : customers) {
            List<Order> orderList = customer.getOrderList();
            System.out.println("orderList = " + orderList);
        }

    }



    @AfterEach
    public void clean(){
        session.close();
    }

}
