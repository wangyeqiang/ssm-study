package org.example.json;


import org.example.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("json")
@ResponseBody
public class JsonController {
    // data -> 请求体 post传过来的数据 name age gender
    // 前端 》json 415 不支持数据类型
    // 原因：json的原生api ,只支持路径参数 和 param参数  request.getParamter("key");parma不支持json
    // json就是前端的格式


    // 解决 1. 导入json处理的依赖
    //         2. 给handlerAdpater配置json转换器
    @PostMapping("data")
    public String data(@RequestBody  Person person){
        System.out.println("person = " + person);
        return "person = " + person;
    }

}
