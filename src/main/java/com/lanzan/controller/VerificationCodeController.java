package com.lanzan.controller;

import com.lanzan.service.VerificationCodeService;
import com.lanzan.service.JudgeWhetherExistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @Autowired
    private JudgeWhetherExistService judgeWhetherExistService;


    /**
     * 判断验证码是否正确-找回密码
     * @param vc_phone 手机号
     * @param vc_code 验证码
     * @return
     */
    @RequestMapping(value = "verifyCodeCorrect")
    @ResponseBody
    public Map<String,Object> getPhoneNewCode(String vc_phone, String vc_code){
        //判断手机号是否存在
        Map<String,Object> map=new HashMap<String,Object>();
        if (vc_phone!=null && vc_code!=null){
            String code=verificationCodeService.getphonenewcode(vc_phone);
            /*if (code.equals(vc_code)){
                //验证码正确
                map.put("res","true");
                return map;
            }else{
                //验证码错误
                map.put("res","false");
                return map;
            }*/
            return isCode(code,vc_code);
        }else{
            return null;
        }
    }

    /**
     * 判断验证码是否正确-注册
     * @param regPhone
     * @param regCode
     * @return
     */
    @RequestMapping(value = "verifyRegCodeCorrect")
    @ResponseBody
    public Map<String,Object> getRegPhoneEnEwCode(String regPhone,String regCode){
        //判断手机号是否存在
        Map<String,Object> map=new HashMap<String,Object>();
        if (regPhone!=null && regCode!=null){
            String code=verificationCodeService.getRegPhoneEnEwCode(regPhone);
            return isCode(code,regCode);
        }else{
            return null;
        }
    }

    //判断验证码是否正确
    private Map<String,Object> isCode(String code,String regCode){
        Map<String,Object> map=new HashMap<String,Object>();
        if (code.equals(regCode)){
            //验证码正确
            map.put("res","true");
        }else {
            //验证码错误
            map.put("res","false");
        }
        return map;
    }

}
