package org.example.pojo;

import lombok.Data;

@Data
public class Order {

    private Integer orderId;

    private String orderName;

    private Integer customerId;

    // 一个订单对应 一个客户  一对一

    // 对象装对应的客户的信息
    private Customer customer;


}
