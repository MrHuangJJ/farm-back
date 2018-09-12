package com.lanzan.service.imp;

import com.lanzan.dao.VerificationCodeMapper;
import com.lanzan.entity.VerificationCode;
import com.lanzan.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "verificationCodeService")
public class VerificationCodeServiceImp implements VerificationCodeService{

    @Autowired
    private VerificationCodeMapper verificationCodeMapper;

    // 添加验证码到数据库
    public void addVerificationCode(VerificationCode verificationCode) {
        verificationCodeMapper.addVerificationCode(verificationCode);
    }

    // 根据手机号查询最新验证码-找回密码
    public String getphonenewcode(String vc_phone) {
        return verificationCodeMapper.getphonenewcode(vc_phone);
    }

    // 根据手机号查询最新验证码-注册
    public String getRegPhoneEnEwCode(String regPhone) {
        return verificationCodeMapper.getRegPhoneEnEwCode(regPhone);
    }
}
