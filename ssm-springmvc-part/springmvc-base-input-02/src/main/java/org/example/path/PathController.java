package org.example.path;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("path")
@ResponseBody
public class PathController {

    // 传过来个path/账号/密码
    // 动态路径设计 {key} = * {key}  在形参列表获取传入的参数
    // 接收路径参数 String account, String password-> 接收param格式参数
    // 必须使用@PathVariable



    @RequestMapping("{account}/{password}")
    public String login(@PathVariable("account") String user, @PathVariable String password){
        System.out.println("user = " + user + ", password = " + password);
        return "user = " + user + ", password = " + password;
    }
}
