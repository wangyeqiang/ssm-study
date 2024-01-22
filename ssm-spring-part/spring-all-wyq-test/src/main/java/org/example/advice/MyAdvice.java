package org.example.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import java.lang.reflect.Modifier;

/**
 * 定义4个增强方法，获取目标方法的信息，返回值，对象
 * <p>
 * 1. 定义方法，增强代码
 * 2. 使用注解指定对应的位置
 * 3. 配置切点表达式选种方法
 * 4. 切面和ioc的配置
 * 5. 开启aspectj注解的支持
 * <p>
 * TODO: 获取增强方法中获取目标方法信息
 * 1. 全部增强方法中，获取目标方法的信息（方法名、参数、访问修饰符、所属类的信息...）
 * (JoinPoint joinPoint)
 * JoinPoint 包含目标方法的信息
 * 2. 返回结果 -  @AfterReturning有效
 * (Obejct result) 代表result接收返回结果
 *     @AfterReturning(value = "execution(* org..impl.*.*(..))", returning = "形参名") return属性添加接收return属性的形参
 * 3. 获取异常信息  - @AfterThrowing有效
 *    (Throable t) t接收异常信息
 *    @AfterThrowing(value = "execution(* org..impl.*.*(..))", throwing = "形参名")
 *
 */
//@Component
//@Aspect
public class MyAdvice {

    // @Before("execution(* org.example.service.impl.*.*(..))")  未提取之前使用的是该种形式
    @Before("org.example.pointcut.MyPointCut.myPc()")
    public void before(JoinPoint joinPoint) {
        // 1. 获取方法所属的类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        // 2. 获取方法名称
        int modifiers = joinPoint.getSignature().getModifiers();
        String s = Modifier.toString(modifiers);
        String name = joinPoint.getSignature().getName(); // 获取方法名称
        // 3. 获取参数列表
        Object[] args = joinPoint.getArgs();
    }

    // returning = "result" 指定用哪个形参来接收返回结果
    @AfterReturning(value = "org.example.pointcut.MyPointCut.myPc()", returning = "result")
    // 获取返回结果，要在形参添加Object
    public void afterReturning(JoinPoint joinPoint, Object result) {

    }

    @After("org.example.pointcut.MyPointCut.myPc()")
    public void after(JoinPoint joinPoint) {

    }

    // throwing = "throwable" 指定用哪个形参来接收返回结果
    @AfterThrowing(value = "org.example.pointcut.MyPointCut.myPc()", throwing = "throwable")
    // 获取异常结果，要在形参添加Throwable
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {

    }
}
