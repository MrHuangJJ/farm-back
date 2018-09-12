package com.lanzan.dao;

import com.lanzan.entity.User;

/**
 *
 * 用户
 */
public interface UserMapper {

    // 根据用户名获取user对象
    User getUserWhereuname(String uname);

}
