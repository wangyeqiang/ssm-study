package org.example.pojo;


import lombok.Data;

@Data
public class User {
    private String name;  // 属性名必须等于参数名


    private int age = 18; // 这里可以配置默认值

}
