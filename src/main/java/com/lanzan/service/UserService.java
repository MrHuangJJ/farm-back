package com.lanzan.service;

import com.lanzan.entity.User;

public interface UserService {

    // 根据用户名获取user对象
    User getUserWhereuname(String uname);

}
