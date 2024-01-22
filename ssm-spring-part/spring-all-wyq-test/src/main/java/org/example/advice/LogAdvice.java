package org.example.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect  // 代表切面
@Order(10)  // 指定一个优先级的值，值越小优先级越高，越高的前置先执行，后置后执行
public class LogAdvice {


    /**
     * 切点表达式的提取和复用
     * 1. 当前类中提取
     *    定义一个空方法
     *    注解 @Pointcut()
     *    增强注解中引用切点表达式的方法即可
     * 2. 创建一个存储切点的类
     *     单独维护切点表达式
     *     其他类的切点方法 类的全限定符.方法名()
     */


    @Before("org.example.pointcut.MyPointCut.pc()")
     public void start(){
         System.out.println("方法开始了");
     }

     @After("org.example.pointcut.MyPointCut.pc()")
     public void after(){
         System.out.println("方法结束了");
     }

     @AfterThrowing("org.example.pointcut.MyPointCut.pc()")
     public void error(){
         System.out.println("方法报错了");
     }

}
