package com.lanzan.controller;

import com.lanzan.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;


    /**
     * 判断验证码是否正确-找回密码
     * @param vc_phone 手机号
     * @param vc_code 验证码
     * @return
     */
    @RequestMapping(value = "verifyCodeCorrect")
    @ResponseBody
    public String getphonenewcode(String vc_phone,String vc_code){
        if (vc_phone!=null && vc_code!=null){
            String code=verificationCodeService.getphonenewcode(vc_phone);
            String outcode="";
            if (code.equals(vc_code)){
                //验证码正确
                outcode="1111";
            }else{
                //验证码错误
                outcode="2222";
            }
            return outcode;
        }else{

        }
        return null;
    }

}
