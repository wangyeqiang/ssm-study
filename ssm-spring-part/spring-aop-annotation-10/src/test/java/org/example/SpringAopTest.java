package org.example;


import org.example.config.JavaConfig;
import org.example.service.Calculator;
import org.example.service.impl.CalculatorPureImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value= JavaConfig.class)
public class SpringAopTest {

    // aop - 代理 - jdk - 接口 - 代理类 - 代理对象和目标对象 拜把子兄弟 兄弟关系
    // aop - 代理
    @Autowired
    private CalculatorPureImpl calculator;
    
    @Test
    public void test(){

        int add = calculator.add(1,1);
        System.out.println("add = " + add);
    }

}
