package com.lanzan.service;

import com.lanzan.dto.UserDto;
import com.lanzan.entity.User;
import com.lanzan.entity.UserInfo;

import java.util.List;

public interface UserService {

    // 根据用户名获取user对象
    User getUserWhereuname(String uname);

    // 根据uid获取头像与昵称
    List<UserInfo> getPhotoAndName(int uid);

    // 根据登录账户获取uid与rid
    UserDto getUserDto(String uName);

}
