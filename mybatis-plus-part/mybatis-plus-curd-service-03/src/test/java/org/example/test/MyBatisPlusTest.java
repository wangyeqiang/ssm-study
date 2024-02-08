package org.example.test;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserService userService;

    @Test
    public void test_save(){
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAge(18);
        user.setEmail("jj");
        user.setName("吕丹丹");
        list.add(user);

        User user1 = new User();
        user.setAge(18);
        user.setEmail("jj");
        user.setName("狗剩子");
        list.add(user1);

        boolean b = userService.saveBatch(list);
        System.out.println("b = " + b);


    }



    @Test
    public void test_saveOrUpdate(){
        // 如果id有值 不为null,修改， 为null插入
        User user = new User();
        user.setId(1L);
        user.setAge(18);
        user.setEmail("jj");
        user.setName("吕丹2");
        userService.saveOrUpdate(user);

    }


    @Test
    public void test_remove(){

        boolean b = userService.removeById(1755437601629814785L);
        System.out.println("b = " + b);
        
    }


    @Test
    public void test_update(){
        User user = new User();
        user.setId(1L);
        user.setAge(18);
        user.setEmail("jj");
        user.setName("xxxx蛋蛋22");
        userService.saveOrUpdate(user);
    }


    @Test
    public void test_getOrList(){
        User byId = userService.getById(1);
        System.out.println("byId = " + byId);
        List<User> list = userService.list(); // 查询全部返回结合
        System.out.println("list = " + list);
    }





}
