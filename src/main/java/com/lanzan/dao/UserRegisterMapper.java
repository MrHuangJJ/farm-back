package com.lanzan.dao;

import com.lanzan.entity.UserRegister;

import java.util.List;

public interface UserRegisterMapper {

    //根据用户id查询所属的合作社或农机站
    List<UserRegister> getUserRegistersByUid(int uid);

    //根据用户id查询用户
    UserRegister getUserRegisterByUid(int uid);

}
