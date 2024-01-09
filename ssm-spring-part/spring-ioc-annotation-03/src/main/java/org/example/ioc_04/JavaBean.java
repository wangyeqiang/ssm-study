package org.example.ioc_04;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JavaBean {

    /**
     * < beand id class
     *  <proerty name= "name"  value="ergouzi"  读取外部配置
     */

    // 方案1：直接赋值
    // 方案2: 注解赋值 @Value注解
    // 默认值语法 @Value($key:value默认值)
    private String name = "二狗子";

    @Value("19")
    private int age;


    @Value("${username:amdin}")
    private String username;

    @Value("${password:xxx}")
    private String password;

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
