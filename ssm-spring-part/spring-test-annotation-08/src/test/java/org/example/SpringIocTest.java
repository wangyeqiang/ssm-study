package org.example;

import org.example.components.A;
import org.example.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


// @SpringJUnitConfig(locations =  指定配置文件 , value = 指定配置类的)
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringIocTest {

    @Autowired
    public A a;

    @Test
    public void test() {

        System.out.println(a);
    }
}
