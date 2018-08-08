package com.lanzan.dao;

import com.lanzan.entity.VerificationCode;

/**
 * 验证码
 *
 */
public interface VerificationCodeMapper {

    // 添加验证码到数据库
    void addVerificationCode(VerificationCode verificationCode);

    // 根据手机号查询最新验证码
    String getphonenewcode(String vc_phone);

}
