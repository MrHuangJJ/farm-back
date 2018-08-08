package com.lanzan.service;

import com.lanzan.entity.User;

/**
 * 找回密码
 *
 */
public interface RetrievePassService {

    // 判断用户名与手机号是否一致
    int getNameAndPhoneAccordance(int uid, String uiphone);

    // 根据用户名修改密码
    void updatePassInuname(User user);

}
