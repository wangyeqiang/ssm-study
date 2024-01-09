package org.example.statics;

import org.example.Calculator;


/**
 * 代理类 中介
 */
public class StaticProxyCaculator implements Calculator
{

    private Calculator calculator;

    /**
     * 使用构造方法 传入目标
     * @param calculator
     */
    public StaticProxyCaculator(Calculator calculator){
        this.calculator = calculator;

    }
    @Override
    public int add(int i, int j) {
        // 非核心业务
        System.out.println("i = " + i + ", j = " + j);

        // 调用目标
        int result = calculator.add(1,1);
        System.out.println("result = " + result);
        return 0;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
