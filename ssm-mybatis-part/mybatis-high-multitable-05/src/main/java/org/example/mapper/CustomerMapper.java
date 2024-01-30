package org.example.mapper;

import org.example.pojo.Customer;

import java.util.List;

public interface CustomerMapper {

    // 查询所有客户信息

    List<Customer> queryList();

}
