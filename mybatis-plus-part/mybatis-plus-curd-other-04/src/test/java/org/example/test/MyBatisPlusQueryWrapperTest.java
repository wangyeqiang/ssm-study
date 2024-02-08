package org.example.test;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusQueryWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_01(){
        // 查询用户名包含a like ， 年龄在20和30之前，并且邮箱不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 条件 动态调用warpper的方法完成拼接即可
        queryWrapper.like("name", "a");
        queryWrapper.between("age",20,30);
        queryWrapper.isNotNull("email");

        // 链式调用
        queryWrapper.like("name", "a").between("age",20,30).isNotNull("email");

        // seelct * from user where name like "%a%" and age between 20 and 30 and email is not null
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }
    
    @Test
    public void test_02(){
        // 按年龄降序查询用户，如果年龄相同按id升序排列
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");

        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }


    @Test
    public  void test_03(){

        // 删除email为空的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        userMapper.delete(queryWrapper);
    }



    @Test
    public void test_04(){
        //将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE username LIKE ? AND age > ? OR email IS NULL)

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20)
                .like("name","a")
                .or().isNull("email") // or第一个条件是or 再有后面的就是and
                .isNull("email");


        User user = new User();
        user.setAge(88);
        user.setEmail("hehehe");
        int update = userMapper.update(user, queryWrapper);
    }


    @Test
    public void test_05(){
        // 查询用户信息的namg 和 age字段
        // 默认全部列

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("id",1L);
        // 默认查询全部列
        queryWrapper.select("name","age"); // 指定列查询
        userMapper.selectList(queryWrapper);
    }


    @Test
    public void test_06(){
        // 前端传入了两个参数name 和 age
        // name不为空 ，作为条件 = 查询
        // age > 18, 作为条件，查询等于age =


        String name = "xx";
        Integer age = 19;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

//        if (StringUtils.isNotBlank(name)){
//            queryWrapper.eq("name",name);
//        }
//
//        if (age != null && age > 18){
//            queryWrapper.eq("age", 18);
//        }

        queryWrapper.eq(StringUtils.isNotBlank(name),"name",name)
                .eq(age != null && age > 18, "age", 18);
        // 每个方法都有一个Boolean condition,允许我们第一位放一个比较表达式 Ture  整个条件生效 False 条件不生效
        userMapper.selectList(queryWrapper);
    }
}
