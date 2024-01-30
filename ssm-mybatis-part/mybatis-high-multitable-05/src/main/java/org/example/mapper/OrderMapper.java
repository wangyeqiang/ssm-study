package org.example.mapper;

import org.example.pojo.Order;

public interface OrderMapper {


    // 根据ID查询订单信息和订单对应的客户

    Order queryOrderById(Integer id);
}
