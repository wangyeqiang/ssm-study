package org.example.ioc_02;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON) // 单例
// @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 多例
@Component
public class JavaBean {
    // 周期方法命名随意，但是必须是 public void没有形参
    @PostConstruct
    public void init() {
        System.out.println("JavaBean" + "INIT");

    }

    @PreDestroy  // 单例才会走destory 如果是多例就不进行销毁管理了
    public void destory(){
        System.out.println("JavaBean" + "destory");
    }
}
