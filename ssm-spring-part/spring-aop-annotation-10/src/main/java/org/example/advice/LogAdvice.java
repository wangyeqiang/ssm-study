package org.example.advice;


import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 增强类
 * <p>
 * 1. 定义方法存储增强代码
 * 具体定义几个方法，根据插入的位置决定
 * 2. 使用注解配置，指定插入目标方法的位置
 * 前置  @Before
 * 后置  @AfterReturning
 * 异常  @AfterThrowing
 * 最后  @After
 * 环绕  @Around
 * <p>
 * try() {
 * 强制
 * 目标方法执行
 * 后置
 * }catch() {
 * 异常
 * }finally{
 * 最后
 * }
 * <p>
 * 3. 配置切点表达式【选中插入的方法， 切点】
 * 4. 补全注解
 * 加入ioc容器，@component
 * 配置切面 @Aspect = 切点 + 增强
 * <p>
 * spring aop重点是配置 --> jdk | cglib
 * <p>
 * 5. 开发aspect的支持
 */

@Component
@Aspect  // 代表切面
@Order(10) // 指定一个优先级的值，值越小优先级越高，越高的前置先执行，后置后执行
public class LogAdvice {
    /**
     * TODO: 切点表达式
     * 固定语法 execution(1 2 3.4.5(6))
     *  1. 访问修饰符
     *   public / private
     *   2. 方法返回参数类型
     *   String int void
     *   如果不考虑访问修饰符和返回值！ 这两位整合成一起写成*
     *   如果要是不考虑，必须都不考虑 ！ 不能出现 * String
     *   3. 包的位置
     *    具体包： com.atguitu.service.imple
     *    单层模糊： com.atguigu.service.*    * 单层模糊
     *    多层模糊： com.. imple      .. 任意层的模糊
     *    细节： .. 不能开头
     *    所有impl包： com..impl
     *   4. 类的名称
     *   具体：CaculationPurlImpl
     *   模糊：*
     *   部分模糊：*Impl
     *   5. 方法名： 语法和类名一致
     *   6. (6)指的是参数列表
     *     没有参数： ()
     *     有具体参数：(String) (String,int)
     *     模糊参数：(..)  有没有参数都可以，有多个也可以
     *     部分模糊:(String..) String 后面有没有无所谓
     *             (..int) int 前面有没有无所谓
     *             (String int)
     *
     *
     *  TODO: 实战
     *  1. 查询到某包某类下，访问修饰符是公有的，返回值为int的全部方法
     *    public init xx.xx.jj.*(..)
     *
     * 2.查询某包下类中第一个参数是String的方法
     *     * xx.jj.zz.*(String..)
     * 3.查询全部包下，无参数的方法！
     *     * *..*.*()
     * 4.查询com包下，以int参数类型结尾的方法
     *     * com..*(..int)
     * 5.查询指定包下，Service开头类的私有返回值int的无参数方法
     *    private int xx.yy.Service*.*()
     */


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
    public void start() {
        System.out.println("方法开始了");
    }

    @After("org.example.pointcut.MyPointCut.pc()")
    public void after() {
        System.out.println("方法结束了");
    }

    @AfterThrowing("org.example.pointcut.MyPointCut.pc()")
    public void error() {
        System.out.println("方法报错了");
    }
}
