package org.example.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.example") // 这里的扫描，包括了org.example下面的所有包
@PropertySource(value = "classpath:jdbc.properties")
@EnableAspectJAutoProxy  // 开启AspectJ的注解，也可以通过spring配置文件实现
@EnableTransactionManagement // 开启事务管理
public class JavaConfigure {


    @Bean
    public DataSource dataSource(@Value("${atguigu.url}") String url, @Value("${atguigu.driver}") String driver, @Value("${atguigu.username}") String username, @Value("${atguigu.password}") String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean // 这里用于事务注解
    public TransactionManager transactionManager(DataSource dataSource) {
        // 内部要进行事务的操作，基于连接池
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        // 需要连接池对象
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
