package com.lanzan.controller;

import com.lanzan.dao.UserMapper;
import com.lanzan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "getUser")
    public void getUser(){
        List<User> users = userMapper.getUserByState();
        for (User user : users) {
            System.out.println(user.getUname());
        }
    }

}
