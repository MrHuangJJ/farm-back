package com.lanzan.service.imp;

import com.lanzan.dao.UserMapper;
import com.lanzan.entity.User;
import com.lanzan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImp implements UserService{

    @Autowired
    private UserMapper userMapper;

    // 根据用户名获取user对象
    public User getUserWhereuname(String uname) {
        return userMapper.getUserWhereuname(uname);
    }
}
