package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 1. service
 * 2. 开启aop注解支持 aspect @Before @After @AfterReturnning @AfterThrowing @Around @Aspect @Order
 * 3. tx声明式事务管理 1。 对应的事务管理器实现[TransactionManagement  DataSource,Hibernate Jpa]  2。 开启事务注解的支持 @Tranactional
 *
 */
@Configuration
@EnableAspectJAutoProxy       // 开启Aop
@EnableTransactionManagement  // 开启事务注解支持
@ComponentScan("org.example.service")  // advice增强也需要扫描
public class ServiceJavaConfig {

    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;

    }
}
