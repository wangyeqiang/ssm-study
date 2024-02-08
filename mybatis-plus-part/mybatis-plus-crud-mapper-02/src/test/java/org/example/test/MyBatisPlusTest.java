package org.example.test;


import org.example.mapper.UserMapper;
import org.example.pojo.User;
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
    private UserMapper userMapper;

    @Test
    public void test_insert(){
        User user = new User();
        user.setAge(88);
        user.setName("呵呵呵");
        user.setEmail("xxx");

        // baseMapper提供的数据库插入方法
        int insert = userMapper.insert(user);
    }



    @Test
    public void  test_delete(){
        // 根据id删除
        int rows = userMapper.deleteById(1755419350396981250L);
        System.out.println("rows = " + rows);

        // 根据age = 20
        Map param = new HashMap();
        param.put("age",20);
        int i = userMapper.deleteByMap(param);
        System.out.println("i = " + i);

        // wapper条件封装对象，无线封装条件
        // userMapper.delete(wapper)

    }



    @Test
    public void test_update(){


        // todo: update 当属性为空的时候，不修改。
        // use id = 1的age 改为30
        User user = new User();
        user.setId(1L);
        user.setAge(30);
        // update user set age = 30 where id = 1
        int i = userMapper.updateById(user);
        System.out.println("i = " + i);

        // 将所有人的年龄改为22
        // update 实体类可以没有id值
        User user1 = new User();
        user1.setAge(22);
        int update = userMapper.update(user, null);// null  没条件，
        System.out.println("update = " + update);
    }



    @Test
    public void test_select(){
        User user = userMapper.selectById(1);

        // ids集合查询
        List<Long> ids = new ArrayList<>();
        ids.add(1L); ids.add(2L);
        List<User> users = userMapper.selectBatchIds(ids);
        System.out.println("users = " + users);
    }


}
