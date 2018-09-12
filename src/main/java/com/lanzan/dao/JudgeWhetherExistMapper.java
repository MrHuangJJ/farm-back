package com.lanzan.dao;

/**
 * 判断是否存在
 *
 */
public interface JudgeWhetherExistMapper {

    // 判断用户名是否存在
    int getunameyesno(String uname);

    // 判断手机号是否存在
    int getPhoneYesNo(String phone);

    // 判断邮箱是否存在
    int getEmailYesNo(String email);

    // 判断carID是否存在
    int getCarIdYesNo(String carId);


}
