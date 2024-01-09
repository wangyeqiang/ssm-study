package org.example.ioc_03;


import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Override
    public String show() {
        return "UserSErviceImpl show";
    }
}
