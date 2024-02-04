package org.example.json;

import org.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


//@Controller
@RequestMapping("json")
//@ResponseBody // 返回json的注解 可以添加到类和方法上
@RestController  // = @ResponseBody   + @Controller
public class JsonController {


    /**
     *  todo: @ResponseBody  表示数据直接放入到响应体返回，不会再走视图解析器
     *         写了这个 快速查找视图，转发和重定向都不生效了
     * @return
     */
    @GetMapping("data")
    public User data(){
        // 对象 json {}
        // 集合 json -> []
        User user = new User();
        user.setName("二狗子");
        user.setAge(3);
        return user; // user -> handlerAdpater 转为json -> @ResponseBody -> json直接返回 【前后端分离】
    }


    @GetMapping("data1")
    public List<User> data1(){
        User user = new User();
        user.setName("二狗子");
        user.setAge(3);

        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }
}
