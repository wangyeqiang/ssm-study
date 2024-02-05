package org.example.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

/**
 * 方式1 ： 保留 mybatis-config.xml配置文件
 * 问题： 如果将datasource 和 mybatis的组件配置到一起 出现@Value注解不生效的问题
 * 原因： 就是mybatis的组件优先加载 @Value还没有读到，
 * 解决办法：分开配置
 */
@Configuration
public class MapperJavaConfig {


    // sqlSessionFactory加入到ioc容器
    // mybatis -> sqlSessionFactory[ioc] -> getObject() -> sqlSessionFactory
    // 方式1 ：外部指定mybatis的配置文件 【mybatis的配置  除了连接池，mapper指定】
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 指定配置文件等信息
        // 指定数据库连接池对象
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 指定外部mybatis配置文件
        // Resource spring core下面的
        Resource resource = new ClassPathResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);

        return sqlSessionFactoryBean;
    }


    // mapper代理对象加入到ioc容器
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        // Mapper代理对象的factoryBean  -> 指定一个包 -》 mapper接口 -》mapper代理对象->ioc
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.example.mapper");  // mapper和mapperxml的所在共同包
        return mapperScannerConfigurer;

    }
}
