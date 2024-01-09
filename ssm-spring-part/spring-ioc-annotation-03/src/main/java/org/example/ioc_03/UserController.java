package org.example.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {

    // 对应property userService 对应类型的bean装配
    // 自动装配注解(DI) 1. ioC容器查找符合类型的组件对象 2. 设置给当前属性(di)
    @Autowired // boolean requied() default true 必须有对应类型的组件
    // 佛系装配 @Autowired(required = false) 可以没有 值 = null boolean requied() default false
    // 不推荐使用 佛系装配 ，装配的数据后期都会有调用，后面会出现空指针
    @Qualifier(value = "userServiceImpl")
    private UserService userService;

    @Resource(name = "userServiceImpl")
    private UserService userService1;


    public void show() {
        // 调用业务层的show
        String show = userService1.show();
        System.out.println("show" + show );
    }
}
