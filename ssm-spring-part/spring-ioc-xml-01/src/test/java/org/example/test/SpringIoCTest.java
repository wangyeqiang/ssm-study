package org.example.test;

import org.example.ioc_03.A;
import org.example.ioc_03.HappyComponent;
import org.example.ioc_05.JavaBean;
import org.example.ioc_04.JavaBean2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {
//    讲解如何创建IOC  并且如何获取配置文件
    public  void  createIoC() {

//        创建容器，选择合适的容器实现即可【推荐】
        // 方法1。 直接创建容器，读取配置文件
        // IOC 和 DI都在源码中 实现
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

    }


    /**
     * 讲解如何从IOC中获取BEAN
     */
    @Test
    public void getBeanFromIoc() {
       // 1. 创建IOC容器对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("spring-03.xml");
        applicationContext.refresh();  // ioc -di 动作

        // 2. 读取ioc容器的组件
        // 方法1.直接通过beanid获取 ,返回值类型是Object ，需要强转，不推荐
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");
        // 方法2.根据beanId，同时指定bean的类型 class
        HappyComponent happyComponent1 = applicationContext.getBean("happyComponent",HappyComponent.class);
        // 方法3.直接根据类型获取
        // HappyComponent happyComponent2 = applicationContext.getBean(HappyComponent.class);
        // TODO 根据bean的类型获取，同一个类型，在IOC容器中只有有一个bean
        // todo 如果ico容器中存在多个同类型的bean 会出现， NounitqueBeanDefinitionException
        // todo ioc配置一定是实现类，但是可以根据接口类型获取值! getBean(类) ; instanceof ioc容器的类型 == true
        A happyComponent2 = applicationContext.getBean(A.class);

        happyComponent2.doWork();
        System.out.println(happyComponent == happyComponent1);
        System.out.println(happyComponent2 == happyComponent1);
    }

    /**
     * 测试ioc配置 和 销毁方法的触发
     */
    @Test
    public void  test_04() {

       // 1. 创建ioc容器就会调用Init
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");


        JavaBean2 javaBean2 =  applicationContext.getBean(JavaBean2.class);
        JavaBean2 javaBean21 = applicationContext.getBean(JavaBean2.class);
        System.out.println(javaBean2);
        System.out.println(javaBean21);
        // ioc容器调用destory
        // ioc会立即释放
        // 2. 正常结束ioc容器
        applicationContext.close();

    }



    /**
     * 读取使用factoryBean工厂配置的组件对象
     */
    @Test
    public void  test_05() {

        // 1. 创建ioc容器就会调用Init
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-05.xml");

        // todo bean的还是javaBean
        JavaBean javaBean =  applicationContext.getBean("javaBean",JavaBean.class);
        // todo： factorybean的工厂也会加入到IOC容器, id标识是$javaBean
        Object bean = applicationContext.getBean("&javaBean");
        System.out.println(bean);

        System.out.println(javaBean);
        // ioc容器调用destory
        // ioc会立即释放
        // 2. 正常结束ioc容器
        applicationContext.close();

    }
}
