package com.lanzan.dao;

import com.lanzan.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * 找回密码
 *
 */
public interface RetrievePassMapper {

    // 判断用户名与手机号是否一致
    int getNameAndPhoneAccordance(@Param("uid") int uid,@Param("uiphone") String uiphone);

    // 根据用户名修改密码
    void updatePassInuname(User user);


}
