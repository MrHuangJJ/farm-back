package com.lanzan.controller;

import com.lanzan.service.JudgeWhetherExistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
    public Map<String,Object> getpwdphone(String uname){
        if (uname!=null && uname!=""){
            int getName=judgeWhetherExistService.getunameyesno(uname);
            return yesNoExist(getName);
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
    public Map<String,Object> getPhoneYesNo(String phone){
        if (phone!=null && phone!=""){
            int getPhone=judgeWhetherExistService.getPhoneYesNo(phone);
            return yesNoExist(getPhone);
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
    public Map<String,Object> getEmailYesNo(String email){
        if (email!=null && email!=""){
            int getEmail=judgeWhetherExistService.getEmailYesNo(email);
            return yesNoExist(getEmail);
        }else{
            return null;
        }
    }


    private Map<String,Object> yesNoExist(int getNPE){
        Map<String,Object> map=new HashMap<String,Object>();
        if (getNPE>0){
            // 存在
            map.put("res","true");
        }else {
            // 不存在
            map.put("res","false");
        }
        return map;
    }

}
