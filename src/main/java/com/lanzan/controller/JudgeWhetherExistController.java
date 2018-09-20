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
        Map<String,Object> map=new HashMap<String,Object>();
        if (uname!=null && uname!=""){
            int getName=judgeWhetherExistService.getunameyesno(uname);
            if (getName>0){
                //存在
                map.put("res","true");
                return map;
            }else{
                //不存在
                map.put("res","false");
                return map;
            }
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
        Map<String,Object> map=new HashMap<String,Object>();
        if (phone!=null && phone!=""){
            int getPhone=judgeWhetherExistService.getPhoneYesNo(phone);
            if (getPhone>0){
                map.put("res","true");
                return map;
            }else{
                //不存在
                map.put("res","false");
                return map;
            }
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
        Map<String,Object> map=new HashMap<String,Object>();
        if (email!=null && email!=""){
            int getEmail=judgeWhetherExistService.getEmailYesNo(email);
            if (getEmail>0){
                map.put("res","true");
                return map;
            }else{
                //不存在
                map.put("res","false");
                return map;
            }
        }else{
            return null;
        }
    }


}
