package org.example.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("order")
@RestController
public class OrderController {


    @GetMapping("data")
    public String data(){
        // 空指针异常
        String name = null ;
//        name.toString();
        System.out.println("OrderController.data");
        return "ok";
    }


    @GetMapping("data1")
    public String data1(){
        // 算数异常
//        int i = 1 /0;
        System.out.println("OrderController.data1");
        return "ok";
    }
}
