package org.example.test;

import org.example.ioc_01.XxxDao;
import org.example.ioc_02.JavaBean;
import org.example.ioc_03.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {


    @Test
    public void testIoc_01() {


        // 1. 创建IOC容器
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-01.xml");


        //2. 获取组件
        // XxxDao bean = applicationContext.getBean(XxxDao.class);
        Object bean = applicationContext.getBean("xxxDao");
        System.out.println("bean" + bean);


        // 添加IOC注解，默认组件名为 类的首字母小写
        Object xxxService = applicationContext.getBean("ergouzi");

        System.out.println("xxxService" + xxxService);
        //3.close容器

    }

    @Test
    public void testIoc_02() {
        // 1. 创建IOC容器
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-02.xml");

        JavaBean bean = applicationContext.getBean(JavaBean.class);
        JavaBean bean1 = applicationContext.getBean(JavaBean.class);
        System.out.println(bean == bean1);

        applicationContext.close();
    }

    @Test
    public void testIoc_03() {
        // 1. 创建IOC容器
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-03.xml");

        UserController userController = applicationContext.getBean(UserController.class);

        // 场景1. IOC容器重有一个UserService对应的实现类对象

        userController.show();

        // 场景2. IOC容器中有一个UserService对应的实现类对象
        // @Autowired 使用它进行装配，【默认】 情况下至少要求有一个Bean否则报错！！


        // 场景3. 如果有同一个类型有多个对应的组件 Autowired也会报错，无法选择
        // 解决1. 成员属性名指定 @Autowired多个组建的时候，默认根据成员属性名指定
        // 解决2. @Qualifier(value = "userServiceImpl") 使用该注解指定获取bean的id,不能单独使用必须配合@Autowired

        // 优化点 @Autowired + @Qualifier(value = "userServiceImpl") = @Resource(name="userServiceImpl")
    }


    @Test
    public void testIoc_04() {
        // 1. 创建IOC容器
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-04.xml");

        org.example.ioc_04.JavaBean javaBean = applicationContext.getBean(org.example.ioc_04.JavaBean.class);

        // 场景1. IOC容器重有一个UserService对应的实现类对象

        System.out.println("bean" + javaBean);


    }
}
