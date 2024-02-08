package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author WYQ
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-02-08 16:54:00
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




