package org.example.requestmapping;

import org.springframework.web.bind.annotation.RequestMapping;

public class UserContronller {

    /
    // handler -> handlerMapping 指定访问地址
    @RequestMapping("/user/login")  // 作用：注册地址，将Handler注册到handlerMapping
    public String login(){
        return null ;
    }



}
