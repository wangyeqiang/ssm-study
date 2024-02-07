package org.example.controller;


import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserService service;


    @GetMapping
    public List<User> query(){
        return mapper.queryAll();
    }


    @GetMapping("delete")
    public List<User> delete(){
        service.delete();
        return null;
    }



}
