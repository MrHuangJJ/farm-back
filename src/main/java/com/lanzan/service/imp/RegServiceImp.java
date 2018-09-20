package com.lanzan.service.imp;

import com.lanzan.dao.RegMapper;
import com.lanzan.entity.RegInfo;
import com.lanzan.entity.User;
import com.lanzan.entity.UserInfo;
import com.lanzan.entity.UserRegister;
import com.lanzan.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "regService")
public class RegServiceImp implements RegService{

    @Autowired
    private RegMapper regMapper;

    // 注册信息添加
    public void addRegInfo(RegInfo regInfo) {
        regMapper.addRegInfo(regInfo);
    }

    // 添加用户
    public void addUser(User user) {
        regMapper.addUser(user);
    }

    // 添加用户信息
    public void addUserInfo(UserInfo userinfo) {
        regMapper.addUserInfo(userinfo);
    }

    // 添加组织信息
    public void addUserRegister(UserRegister userregister) {
        regMapper.addUserRegister(userregister);
    }

    //  删除User
    public void deleteUser(User user) {
        regMapper.deleteUser(user);
    }


}
