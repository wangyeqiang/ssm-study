package org.example.param;

import org.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("param")
public class ParamController {

    // 直接接收
    // param/data?name=root&age=18
    // 只要求在形参列表填写对应名称的参数即可
    // 1。 名称相同， 2。 可以不传递，不报错
    @RequestMapping("data")
    @ResponseBody
    public String data(String name , int age){
        System.out.println("name = " + name + ", age = " + age);
        return "name = " + name + ", age = " + age ;
    }



    // 注解指定
    // 任意指定参数名 要求必须传递 要求不必须传递  给予一个默认值

    // /param/data1?account=root&page=1
    // 要去account必须传递 ，page不必须传递 ，如果不传递就选1

    /**
     * @RequestParam 只加在形参列表，指定请求参数名或者是否必须传递，非必须传递可指定默认值
     *      用法： @RequestParam(value="account") name,value指定参数名，默认按形参名，如果参数名和形参名一致 可省略
     *       @RequestParam(required = false,defaultValue = "1") int page)
     *             required  代表前端必须传递 ，如果不传递前端报400错误  defaultValue 设置默认值
     *
     * @param username
     * @param page
     * @return
     */
    @GetMapping("data1")
    @ResponseBody
    public String data1(@RequestParam(value="account") String username, @RequestParam(required = false,defaultValue = "1") int page){
        System.out.println("username = " + username + ", page = " + page);
        return "username = " + username + ", page = " + page;
    }


    // 特殊值
    // 1名多值  key=1&key=2
    // param/data2?hbs=吃&hbs=玩&hbs=学习
    // 不加@RequestParam 会把hbs的字符串直接赋值给集合！类型异常
    // 加了注解 经理会将集合add到对应的字符串
    @GetMapping("data2")
    @ResponseBody
    public String data2(@RequestParam  List<String> hbs){
        System.out.println("hbs = " + hbs);
        return "ok";
    }

    // 使用实体对象接值  用户注册(u用户的信息)  对应的实体类  -》 插入到数据库表
    // param/data3?name=二狗子&age=18 准备一个对应的get|set方法类即可 -> 形参列表声明对象参数即可
    @RequestMapping("data3")
    @ResponseBody
    public String data3(User user){
        System.out.println("user = " + user);
        return user.toString();

    }

}
