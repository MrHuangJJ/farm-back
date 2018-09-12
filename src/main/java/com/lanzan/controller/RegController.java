package com.lanzan.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.lanzan.entity.RegInfo;
import com.lanzan.entity.VerificationCode;
import com.lanzan.service.RegService;
import com.lanzan.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RegController {

    @Autowired
    private RegService regService;

    @Autowired
    private VerificationCodeService verificationCodeService;


    /**
     * 注册-获取验证码
     * @param regPhone 手机号
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getRegVerificationCode")
    @ResponseBody
    public void getRegVerificationCode(String regPhone)throws Exception{
        if (regPhone!=null && regPhone!=""){
            //存在 发送验证码
            //初始化单发
            SmsSingleSender singleSender = new SmsSingleSender(1400083652,"6f274344557c014f52e51896045404be");
            //6位随机数
            Random random = new Random();
            String randomCode = "";
            for (int i=0;i<6;i++)
            {
                randomCode+=random.nextInt(10);
            }
            singleSender.send(0,"86", regPhone ,randomCode+"为您的验证码，请于2分钟内填写","","");
            VerificationCode verificationCode=new VerificationCode();
            verificationCode.setVc_phone(regPhone);
            verificationCode.setVc_code(randomCode);
            //设置注册的验证码状态为A
            verificationCode.setVc_state("A");
            //将验证码添加到数据库
            verificationCodeService.addVerificationCode(verificationCode);
        }

    }

    /**
     * 添加注册信息
     * @param regInfo
     * @return
     */
    @RequestMapping(value = "addRegInfo",method = RequestMethod.POST)
    @ResponseBody
    public String addRegInfo(RegInfo regInfo){
        if (regInfo.getRi_uname()!=null && regInfo.getRi_uname()!=""
                && regInfo.getRi_upass()!=null && regInfo.getRi_upass()!=""
                && regInfo.getRi_uiphoto()!=null && regInfo.getRi_uiphoto()!=""
                && regInfo.getRi_urtype()!=null && regInfo.getRi_urtype()!=""){
            regService.addRegInfo(regInfo);
            return "login";
        }else {
            return null;
        }
    }


}
