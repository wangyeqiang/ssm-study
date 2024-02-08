package org.example.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){


        // Ipage -> page
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage( page, null);

        // 结果 page 最后也会被封装结果
        long current = page.getCurrent(); // 页码
        long size = page.getSize();// 页容量
        List<User> records = page.getRecords(); // 当前业数据
        long total = page.getTotal(); // 总条数
    }



    @Test
    public  void testMypage(){

        Page<User> page = new Page<>(1,3);
        userMapper.queryByAge(page,1);

        // 结果 page 最后也会被封装结果
        long current = page.getCurrent(); // 页码
        System.out.println("current = " + current);
        long size = page.getSize();// 页容量
        System.out.println("size = " + size);
        List<User> records = page.getRecords(); // 当前业数据
        System.out.println("records = " + records);
        long total = page.getTotal(); // 总条数
        System.out.println("total = " + total);
    }


    @Test
    public void testDelete(){
        // 全表删除
        userMapper.delete(null);
    }


}
