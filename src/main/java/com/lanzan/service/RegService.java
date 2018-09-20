package com.lanzan.service;

import com.lanzan.entity.RegInfo;
import com.lanzan.entity.User;
import com.lanzan.entity.UserInfo;
import com.lanzan.entity.UserRegister;

/**
 *
 * 注册
 */
public interface RegService {

    // 注册信息添加
    void addRegInfo(RegInfo regInfo);

    // 添加用户
    void addUser(User user);

    // 添加用户信息
    void addUserInfo(UserInfo userinfo);

    // 添加组织信息
    void addUserRegister(UserRegister userregister);

    // 删除User
    void deleteUser(User user);


}
