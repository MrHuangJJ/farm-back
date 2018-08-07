package com.lanzan.dao;

import com.lanzan.entity.User;

import java.util.List;

public interface UserMapper {

    // 根据审核状态 查询用户 0 未审核 1 通过审核 2 未通过审核
    public List<User> getUserByState();

}
