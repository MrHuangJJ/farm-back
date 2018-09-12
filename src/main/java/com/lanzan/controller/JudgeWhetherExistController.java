package com.lanzan.controller;

import com.lanzan.service.JudgeWhetherExistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JudgeWhetherExistController {

    @Autowired
    private JudgeWhetherExistService judgeWhetherExistService;

    /**
     * 判断用户名是否存在
     * @param uname
     * @return
     */
    @RequestMapping(value = "getJudgeUnameWhetherExist")
    @ResponseBody
    public String getpwdphone(String uname){
        if (uname!=null && uname!=""){
            int getName=judgeWhetherExistService.getunameyesno(uname);
            String getNameExist="";
            if (getName>0){
                //存在
                getNameExist="true";
            }else{
                //不存在
                getNameExist="false";
            }
            return getNameExist;
        }else{
            return null;
        }
    }

    /**
     * 判断手机号是否存在
     * @param phone
     * @return
     */
    @RequestMapping(value = "getJudgePhoneWhetherExist")
    @ResponseBody
    public String getPhoneYesNo(String phone){
        if (phone!=null && phone!=""){
            int getPhone=judgeWhetherExistService.getPhoneYesNo(phone);
            String getPhoneExist="";
            if (getPhone>0){
                //存在
                getPhoneExist="true";
            }else{
                //不存在
                getPhoneExist="false";
            }
            return getPhoneExist;
        }else{
            return null;
        }
    }

    /**
     * 判断邮箱是否存在
     * @param email
     * @return
     */
    @RequestMapping(value = "getJudgeEmailWhetherExist")
    @ResponseBody
    public String getEmailYesNo(String email){
        if (email!=null && email!=""){
            int getEmail=judgeWhetherExistService.getEmailYesNo(email);
            String getEmailExist="";
            if (getEmail>0){
                //存在
                getEmailExist="true";
            }else{
                //不存在
                getEmailExist="false";
            }
            return getEmailExist;
        }else{
            return null;
        }
    }


}
