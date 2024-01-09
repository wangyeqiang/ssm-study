package org.example.ioc_04;

public class JavaBean {
    /**
     * 必须是Public void返回值 必须是无参数
     * 命名随意
     * 初始化方法 -> 初始化业务逻辑
     */
    public  void init(){
        System.out.println("javaBean.init");
    }

    /**
     * 必须是Public void返回值 必须是无参数
     * 命名随意
     * 销毁方法 -> 初始化业务逻辑
     */
    public  void clear(){
        System.out.println("JavaBean.destory");
    }
}
