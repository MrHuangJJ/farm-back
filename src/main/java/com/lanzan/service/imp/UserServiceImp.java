package com.lanzan.service.imp;

import com.lanzan.dao.UserMapper;
import com.lanzan.dto.UserDto;
import com.lanzan.entity.User;
import com.lanzan.entity.UserInfo;
import com.lanzan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    // 根据用户名获取user对象
    public User getUserWhereuname(String uname) {
        return userMapper.getUserWhereuname(uname);
    }

    // 根据uid获取头像与昵称
    public List<UserInfo> getPhotoAndName(int uid) {
        return userMapper.getPhotoAndName(uid);
    }

    // 根据登录账户获取uid与rid
    public UserDto getUserDto(String uName) {
        return userMapper.getUserDto(uName);
    }


}
