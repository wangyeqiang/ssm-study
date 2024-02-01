package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 定义handler -> springmvc/hello  reutnr "hello springmvc!!"

    @RequestMapping("springmvc/hello")  // 对外王文得治，到handlerMapping注册的注解
    @ResponseBody // 直接返回字符串给前端，不要找视图解析器
    public String hello(){
        System.out.println("HelloController.hello");

        return "hello springmvc";
    }

}
