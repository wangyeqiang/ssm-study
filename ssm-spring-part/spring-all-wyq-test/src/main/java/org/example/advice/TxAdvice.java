package org.example.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxAdvice {

    @Before("org.example.pointcut.MyPointCut.pc()")
    public void begin(){
        System.out.println("事务开始了");
    }

    @After("org.example.pointcut.MyPointCut.pc()")
    public void commit(){
        System.out.println("事务提交");
    }

    @AfterThrowing("org.example.pointcut.MyPointCut.pc()")
    public void rollback(){
        System.out.println("事务回滚");
    }
}
