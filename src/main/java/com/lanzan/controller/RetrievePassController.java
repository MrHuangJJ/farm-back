package com.lanzan.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.lanzan.entity.User;
import com.lanzan.entity.VerificationCode;
import com.lanzan.service.VerificationCodeService;
import com.lanzan.service.RetrievePassService;
import com.lanzan.service.ConditionSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RetrievePassController {

    @Autowired
    private RetrievePassService retrievePassService;
    @Autowired
    private ConditionSelectService conditionSelectService;
    @Autowired
    private VerificationCodeService verificationCodeService;


    /**
     * 找回密码-获取验证码
     * @param uname 用户名
     * @param uiphone 手机号
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getVerificationCode")
    @ResponseBody
    public String getVerificationCode(String uname,String uiphone)throws Exception{
        //根据uname获取uid
        int uid=conditionSelectService.unamegetuid(uname);
        //根据获取的uid和uiphone判断手机号是否存在
        int getyesno=retrievePassService.getNameAndPhoneAccordance(uid,uiphone);
        String getuiphoneAccordance="";
        if (getyesno>0){
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
            singleSender.send(0,"86", uiphone ,randomCode+"为您的验证码，请于2分钟内填写","","");
            VerificationCode verificationCode=new VerificationCode();
            verificationCode.setVc_phone(uiphone);
            verificationCode.setVc_code(randomCode);
            //设置找回密码的验证码状态为B
            verificationCode.setVc_state("B");
            //将验证码添加到数据库
            verificationCodeService.addVerificationCode(verificationCode);
        }else{
            //不存在
            getuiphoneAccordance="2222";
        }
        return getuiphoneAccordance;
    }

    /**
     * 修改密码
     * @param user uname 用户名 upass 密码
     * @return
     */
    @RequestMapping(value = "updatePassInuname")
    @ResponseBody
    public String updatePassInuname(User user){
        retrievePassService.updatePassInuname(user);
        return "login";
    }


}
