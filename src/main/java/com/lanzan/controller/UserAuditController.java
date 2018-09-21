package com.lanzan.controller;

import com.lanzan.entity.RegInfo;
import com.lanzan.entity.User;
import com.lanzan.entity.UserInfo;
import com.lanzan.entity.UserRegister;
import com.lanzan.service.UserAuditService;
import com.lanzan.service.RegService;
import com.lanzan.service.JudgeWhetherExistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserAuditController {

    @Autowired
    private UserAuditService userAuditService;

    @Autowired
    private RegService regService;

    @Autowired
    private JudgeWhetherExistService judgeWhetherExistService;

    /**
     * 查询注册用户信息
     *
     * @return
     */
    @RequestMapping(value = "listRegInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> listRegInfo(int page, int limit){
        int sum=(page-1)*limit;
        int count=userAuditService.endPageListRegInfo();
        List<RegInfo> regInfos = userAuditService.listRegInfo(sum,limit);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data",regInfos);
        return map;
    }


    /**
     *
     * 修改审核状态通过
     */
    @RequestMapping(value = "updateAuditState", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateAuditState(RegInfo regInfo){
        Map<String,Object> map=new HashMap<String,Object>();
        if (regInfo.getRi_uname()!=null && regInfo.getRi_uname()!=""
                && regInfo.getRi_upass()!=null && regInfo.getRi_upass()!=""
                && regInfo.getRi_uiname()!=null && regInfo.getRi_uiname()!=""
                && regInfo.getRi_uiphone()!=null && regInfo.getRi_uiphone()!=""
                && regInfo.getRi_uiemail()!=null && regInfo.getRi_uiemail()!=""
                && regInfo.getRi_uraddress()!=null && regInfo.getRi_uraddress()!=""){
            regInfo.setRi_auditState("已通过");
            User user=new User();
            user.setUid(regInfo.getRi_uid());
            user.setUname(regInfo.getRi_uname());
            user.setUpass(regInfo.getRi_upass());
            UserInfo userInfo=new UserInfo();
            userInfo.setUid(regInfo.getRi_uid());
            userInfo.setUi_name(regInfo.getRi_uiname());
            userInfo.setUi_photo(regInfo.getRi_uiphone());
            userInfo.setUi_phone(regInfo.getRi_uiphone());
            userInfo.setUi_email(regInfo.getRi_uiemail());
            userInfo.setUi_city(regInfo.getRi_uicity());
            UserRegister userRegister=new UserRegister();
            userRegister.setUid(regInfo.getRi_uid());
            userRegister.setUr_abbreviation(regInfo.getRi_urabbreviation());
            userRegister.setUr_address(regInfo.getRi_uraddress());
            userRegister.setUr_fullname(regInfo.getRi_urfullname());
            userRegister.setUr_license(regInfo.getRi_urlicense());
            userRegister.setUr_logo(regInfo.getRi_urlogo());
            userRegister.setUr_principal(regInfo.getRi_urprincipal());
            userRegister.setUr_type(Integer.parseInt(regInfo.getRi_urtype()));
            int s=judgeWhetherExistService.getunameyesno(regInfo.getRi_uname());
            if (s>0){
                map.put("res","false");
                return map;
            }else {
                regService.addUser(user);
                regService.addUserInfo(userInfo);
                regService.addUserRegister(userRegister);
                userAuditService.updateAuditState(regInfo);
                map.put("res","true");
                return map;
            }
        }else {
            map.put("res","false");
            return map;
        }

    }

    /**
     * 删除用户
     *
     * @return
     */
    @RequestMapping(value = "deleteAuditState")
    @ResponseBody
    public Map<String,Object> deleteAuditState(RegInfo regInfo){
        Map<String,Object> map=new HashMap<String,Object>();
        if (regInfo.getRi_uname()!=null && regInfo.getRi_uname()!=""){
            userAuditService.deleteAuditState(regInfo);
            User user=new User();
            user.setUname(regInfo.getRi_uname());
            regService.deleteUser(user);
            map.put("res","true");
            return map;
        }else {
            map.put("res","false");
            return map;
        }

    }


}
