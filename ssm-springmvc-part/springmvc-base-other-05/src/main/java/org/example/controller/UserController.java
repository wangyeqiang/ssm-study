package org.example.controller;


import org.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("user")
@RestController
public class UserController {

  // 接收用户数据，用户校验注解

    /**
     * 1. 正常给实体类属性添加校验注解
     * 2. handler(@Validated 实体类 对象）
     * 细节： param | json 校验注解都有效果
     *       json参数  - @RequestBody
     *
     * 如果，不符合检验规则直接向前端抛出异常了。
     * todo: 接受错误绑定信息，自定义返回结果！ 约定 ： 参数错误 -》 {code：400} -》 前端
     * 捕捉错误绑定错误信息：
     * 1. handler(校验对象， BindingResult result ) 要求：BindingResult 必须紧挨着 校验对象
     * 2. BindingResult获取错误 绑定错误
     * @param user
     * @return
     */
    @PostMapping("register")
    public Object register(@Validated @RequestBody User user , BindingResult result){

        if(result.hasErrors()){
            // 有绑定错误，就不直接返回了，由我们自己决定
            Map data = new HashMap();
            data.put("code",400);
            data.put("msg","参数校验异常");
            return data;

        }
        System.out.println("user = " + user);
        return  user;
    }


    @GetMapping("data")
    public String data(){
        // 空指针异常
        String name = null ;
//        name.toString();
        System.out.println("UserController.data");
        return "ok";
    }


    @GetMapping("data1")
    public String data1(){
        // 算数异常
//        int i = 1 /0;
        System.out.println("UserController.data1");
        return "ok";
    }
}
