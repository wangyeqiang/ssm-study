package org.example;

import org.example.config.JavaConfigure;
import org.example.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfigure.class)
public class AopTest {

    @Autowired
    /**
     * aop - 代理- jdk - 接口 - 代理类 - 代理对象和目标对象 拜把子 兄弟关系-  接口接值
     * aop - ioc中真正存储的是代理对象，而不是目标对象
     */
    // private CalculatorPureImpl calculator; // 这个会报错
    private Calculator calculator;

    @Test
    public void test(){
        int add = calculator.add(1,0);
        System.out.println("add = " + add);
    }
}
