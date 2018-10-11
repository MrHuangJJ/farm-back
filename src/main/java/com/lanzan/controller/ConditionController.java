package com.lanzan.controller;

import com.lanzan.dto.UserDto;
import com.lanzan.entity.Driver;
import com.lanzan.entity.AgriculturalMachinery;
import com.lanzan.entity.HomeworkSeason;
import com.lanzan.service.ConditionSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ConditionController {

    @Autowired
    private ConditionSelectService conditionSelectService;


    /**
     * 查询农机车牌和农机编号
     *
     * @return
     */
    @RequestMapping(value = "getAmNameAndId")
    @ResponseBody
    public Map<String,Object> getAmNameAndId(HttpServletRequest request){
        UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
        //int uid = userDao.getUid();
        int uid = 1;
        List<AgriculturalMachinery> amNameAndId=conditionSelectService.getAmNameAndId(uid);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("data",amNameAndId);
        return map;
    }

    /**
     * 
     *
     * @return
     */
    @RequestMapping(value = "getAmSm")
    @ResponseBody
    public Map<String,Object> getAmSm(){
        List<AgriculturalMachinery> amSm=conditionSelectService.getAmSm();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("data",amSm);
        return map;
    }

    /**
     * 查询驾驶员名称与作业季编号
     *
     * @return
     */
    @RequestMapping(value = "getDriverNameAndId")
    @ResponseBody
    public Map<String,Object> getDriverNameAndId(HttpServletRequest request){
        UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
        //int uid = userDao.getUid();
        int uid = 1;
        List<Driver> driverNameAndId=conditionSelectService.getDriverNameAndId(uid);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("data",driverNameAndId);
        return map;
    }

    /**
     * 查询作业季名称与作业季编号
     *
     * @return
     */
    @RequestMapping(value = "getHsNameAndId")
    @ResponseBody
    public Map<String,Object> getHsNameAndId(HttpServletRequest request){
        UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
        //int uid = userDao.getUid();
        int uid = 1;
        List<HomeworkSeason> hsNameAndId=conditionSelectService.getHsNameAndId(uid);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("data",hsNameAndId);
        return map;
    }

}
