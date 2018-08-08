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
        if (uname!=null){
            int getname=judgeWhetherExistService.getunameyesno(uname);
            System.out.println("=="+getname);
            String getunameExist="";
            if (getname>0){
                //存在
                getunameExist="1234";
            }else{
                //不存在
                getunameExist="4321";
            }
            return getunameExist;
        }else{

        }
        return null;
    }

}
