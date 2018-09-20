package com.lanzan.controller;

import com.lanzan.entity.UserInfo;
import com.lanzan.entity.UserRegister;
import com.lanzan.dto.MyDataDto;
import com.lanzan.service.MyDataDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyDataDtoController {

    @Autowired
    private MyDataDtoService myDataDtoService;

    /**
     * 根据uid查询个人资料
     * @param uid
     *
     * @return
     */
    @RequestMapping(value = "listMyDataDto", method = RequestMethod.GET)
    @ResponseBody
    public List<MyDataDto> listMyDataDto(int uid){
        List<MyDataDto> myDataDtos=myDataDtoService.listMyDataDto(uid);
        return myDataDtos;
    }


    /**
     * 根据uid查询修改资料
     * @param userInfo
     *
     * @return
     */
    @RequestMapping(value = "updateMyDataDto", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateMyDataDto(UserInfo userInfo, UserRegister userRegister){
        Map<String,Object> map=new HashMap<String,Object>();
        if (userInfo.getUi_name()!=null && userInfo.getUi_name()!=""
                && userInfo.getUi_phone()!=null && userInfo.getUi_phone()!=""
                && userInfo.getUi_email()!=null && userInfo.getUi_email()!=""
                && userRegister.getUr_fullname()!=null && userRegister.getUr_fullname()!=""
                && userRegister.getUr_principal()!=null && userRegister.getUr_principal()!=""){
            myDataDtoService.updateUserInfoDto(userInfo);
            myDataDtoService.updateUserRegisterDto(userRegister);
            map.put("res","true");
            return map;
        }else {
            map.put("res","false");
            return map;
        }

    }

}
