package org.example.ioc_03;


import org.junit.jupiter.api.Test;

public class HappyComponent implements A{

    //默认包含无参数构造函数

    public void doWork() {
        System.out.println("HappyComponent.doWork");
    }
}