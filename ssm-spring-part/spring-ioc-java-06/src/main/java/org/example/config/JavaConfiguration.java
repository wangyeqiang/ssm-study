package org.example.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 1. 包扫描注解配置
 * 2. 引入外部文件
 * 3. 声明第三方依赖的bean组件
 *
 * 步骤1 ： 添加 @Configuration 代表是配置类
 * 步骤2 ： 实现上面的3个功能组件
 *
 */
@ComponentScan(value = "org.example.ioc_01")
@PropertySource(value = "classpath:jdbc.properties")
// @ComponentScan(value = {"org.example.ioc_01","org.example.ioc_01"}) 多个包的配置
@Configuration
public class JavaConfiguration {

    @Value("${atguigu.url}")
    private String url;
    @Value("${atguigu.driverName}")
    private String driverName;
    @Value("${atguigu.userName}")
    private String userName;
    @Value("${atguigu.passWord}")
    private String passWord;
    /**
     * 方法的返回值类型就等于  bean组件的类 或者 接口、父类
     * 方法的名字 bean = id
     * 方法体可以自定义实现 即可
     *
     * 最重要的一步： @Bean 让配置类的方法 创建的对象 存储到IOC容器中
     *
     * 问题1：beanName的问题
     *         默认：方法名
     *         指定： name/value 属性起名字，覆盖方法名
     *
     * 问题2：周期方法如何指定
     *         原有注解方案：PostContruct + PreDestory注解
     * @Bean属性 initMethod 或 destroyMethod
     *
     * 问题3：作用域
     *        用@Scope注解 默认是单例
     *
     * 问题4：如何引用其他的IOC组件
     *      1. 直接调用对方的bean方法
     *      2. 直接形参变量进行引用，要求对方必须有对应的组件，如果有多个，形参名 = 组件id标识即可
     *
     */
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(name = "ergouzi", initMethod = "", destroyMethod = "")
    public DruidDataSource dataSource1 () {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverName);
        dataSource.setUsername(userName);
        dataSource.setPassword(passWord );
        return dataSource;
    };

    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(name = "lvdandan", initMethod = "", destroyMethod = "")
    public DruidDataSource dataSource2 () {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverName);
        dataSource.setUsername(userName);
        dataSource.setPassword(passWord );
        return dataSource;
    };

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 需要DataSource 需要ioc中的其他组件
        // 方案1 , 如果其他组件也是@Bean方法 可以直接调用 | 从Ioc中获取组件，不退家
        jdbcTemplate.setDataSource(dataSource1());
        return  jdbcTemplate;

    }

    @Bean
    public JdbcTemplate jdbcTemplate1(DataSource lvdandan, DataSource ergouzi){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 需要DataSource 需要ioc中的其他组件
        // 方案2 , ioc可以在形参列表声明想要的组件类型，可以是1个或多个 | ioc容器也会注入
        // 如果形参变量 要求必须有对应类型组件
        // 如果有多个，可以使用形参名称等同于beanid标识即可

        jdbcTemplate.setDataSource(lvdandan);
        return  jdbcTemplate;

    }
}
