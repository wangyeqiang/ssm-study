package org.example.config;


import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 方式1 ： 不保留 mybatis-config.xml配置文件 全部属性都在类中配置
 * 问题： 如果将datasource 和 mybatis的组件配置到一起 出现@Value注解不生效的问题
 * 原因： 就是mybatis的组件优先加载 @Value还没有读到，
 * 解决办法：分开配置
 */
@Configuration
public class MapperJavaConfigNew {


    // sqlSessionFactory加入到ioc容器
    // mybatis -> sqlSessionFactory[ioc] -> getObject() -> sqlSessionFactory
    // 方式1 ：外部指定mybatis的配置文件 【mybatis的配置  除了连接池，mapper指定】
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 指定配置文件等信息
        // 指定数据库连接池对象
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 指定mybatis配置文件的功能，使用代码的形式
        /*


        <settings>
        <!-- 开启驼峰式映射-->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
        <!-- 开启logback日志输出-->
        <setting name="logImpl" value="SLF4J"/>
        <!--开启resultMap自动映射 -->
        <setting name="autoMappingBehavior" value="FULL"/>
    </settings>

    <typeAliases>
        <!-- 给实体类起别名 -->
        <package name="com.atguigu.pojo"/>
    </typeAliases>

    <plugins>
        <plugin interceptor="com.github.pagehelper.PageInterceptor">
            <!--
                helperDialect：分页插件会自动检测当前的数据库链接，自动选择合适的分页方式。
        你可以配置helperDialect属性来指定分页插件使用哪种方言。配置时，可以使用下面的缩写值：
        oracle,mysql,mariadb,sqlite,hsqldb,postgresql,db2,sqlserver,informix,h2,sqlserver2012,derby
                （完整内容看 PageAutoDialect） 特别注意：使用 SqlServer2012 数据库时，
        https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md#%E5%A6%82%E4%BD%95%E9%85%8D%E7%BD%AE%E6%95%B0%E6%8D%AE%E5%BA%93%E6%96%B9%E8%A8%80
        -->
            <property name="helperDialect" value="mysql"/>
        </plugin>
    </plugins>
              */
        org.apache.ibatis.session.Configuration configuration  = new  org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setLogImpl(Slf4jImpl.class);
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);

        // org.apache.ibatis.session.Configuration  存储setting的配置文件
        sqlSessionFactoryBean.setConfiguration(configuration);

        // 别名设置
        sqlSessionFactoryBean.setTypeAliasesPackage("org.example.pojo");

        // 插件设置
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect","mysql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.addPlugins(pageInterceptor);

        return sqlSessionFactoryBean;
    }


    // mapper代理对象加入到ioc容器
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        // Mapper代理对象的factoryBean  -> 指定一个包 -》 mapper接口 -》mapper代理对象->ioc
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.exampler.mapper");  // mapper和mapperxml的所在共同包
        return mapperScannerConfigurer;

    }
}
