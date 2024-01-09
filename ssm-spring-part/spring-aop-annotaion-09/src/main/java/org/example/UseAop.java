package org.example;

import org.example.statics.StaticProxyCaculator;

public class UseAop {
    public static void main(String[] args) {
        // 房东 目标
        Calculator target = new org.example.CalculatorPureImpl();


        // 中介 代理
        Calculator proxy = new StaticProxyCaculator(target);


        int add = proxy.add(1,1);

        System.out.println(add
        );

    }
}
