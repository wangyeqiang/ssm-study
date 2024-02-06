package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 1, 配置类 @SpringBootCOnfiguration
// 2. 自动装载配置 @EnableAutoConfiguration 自动加载其他配置类
// 3. @ComponentScan 默认是当前类所在包，子包的注解
@SpringBootApplication  // 代表是一个启动类
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args); // 自动创建ioc容器，启动tomcat服务器软件
    }
}
