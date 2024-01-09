package org.example.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@ComponentScan("org.example")
@Configuration
@EnableAspectJAutoProxy // 开启AspectJ的注解
public class JavaConfig {

}
