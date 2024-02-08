package org.example.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisUpdateWrapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void test_04(){
        //将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE username LIKE ? AND age > ? OR email IS NULL)

        // QueryWrapper修改【条件】
        // 1. 准备要修改的实体类数据
        // 2. 不能改为null
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20)
                .like("name","a")
                .or().isNull("email") // or第一个条件是or 再有后面的就是and
                .isNull("email");


        // 要求改的数据
        User user = new User();
        user.setAge(88);
        user.setEmail("hehehe");
        int update = userMapper.update(user, queryWrapper);
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

        userMapper.update(null, updateWrapper);


    }
}
