package com.lanzan.service;

import com.lanzan.entity.VerificationCode;

/**
 * 验证码
 *
 */
public interface VerificationCodeService {

    // 添加验证码到数据库
    void addVerificationCode(VerificationCode verificationCode);

    // 根据手机号查询最新验证码-找回密码
    String getphonenewcode(String vc_phone);

    // 根据手机号查询最新验证码-注册
    String getRegPhoneEnEwCode(String regPhone);

}
