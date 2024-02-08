package org.example.test;


import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusLambdaQueryWrapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void test_01(){
        // 查询用户名包含a like ， 年龄在20和30之前，并且邮箱不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 链式调用
        queryWrapper.like("name", "a").between("age",20,30).isNotNull("email");
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, "a")
                .between(User::getAge,20,30)
                .isNotNull(User::getEmail);

        // seelct * from user where name like "%a%" and age between 20 and 30 and email is not null
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
//        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }


    @Test
    public void test_05(){
        //将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE username LIKE ? AND age > ? OR email IS NULL)

        // QueryWrapper修改【条件】
        // 1. 准备要修改的实体类数据
        // 2. 不能改为null

        // UpdateWrapper修改 【条件 修改】
        // 1. 直接携带修改数据set("列名"，“值”)
        // 2. 指定任意修改至set("列名", null)
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.gt("age",20)
                .like("name","a")
                .or().isNull("email") // or第一个条件是or 再有后面的就是and
                .isNull("email")
                .set("email",null)
                .set("age",99);

//        TableInfoHelper.initTableInfo(new MapperBuilderAssistant(new MybatisConfiguration(), ""), User.class);
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<User>();
        lambdaUpdateWrapper.gt(User::getAge,20)
                .like(User::getName,"a")
                .or().isNull(User::getEmail) // or第一个条件是or 再有后面的就是and
                .isNull(User::getEmail)
                .set(User::getEmail,"xxx")
                .set(User::getAge,99);


        userMapper.update(null, lambdaUpdateWrapper);


    }
}
