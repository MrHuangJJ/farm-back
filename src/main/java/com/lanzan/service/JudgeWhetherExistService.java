package com.lanzan.service;

/**
 * 判断是否存在
 *
 */
public interface JudgeWhetherExistService {

    // 判断用户名是否存在
    int getunameyesno(String uname);
    int getAuditNameYesNo(String uname);

    // 判断手机号是否存在
    int getPhoneYesNo(String phone);
    int getAuditPhoneYesNo(String phone);

    // 判断邮箱是否存在
    int getEmailYesNo(String email);
    int getAuditEmailYesNo(String email);

    // 判断carID是否存在
    int getCarIdYesNo(String carId);

}
