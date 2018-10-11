package com.lanzan.controller;

import com.lanzan.dto.UserDto;
import com.lanzan.entity.Driver;
import com.lanzan.service.DriverService;
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
public class DriverController {

    @Autowired
    private DriverService driverService;

    /**
     * 添加驾驶员
     * @param driver
     *
     * @return
     */
    @RequestMapping(value = "addDriver", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addDriver(HttpServletRequest request,Driver driver){
        Map<String,Object> map=new HashMap<String,Object>();
        if (driver.getDname()!=null && driver.getDname()!=""
                && driver.getDphone()!=null && driver.getDphone()!=""
                && driver.getDcard()!=null && driver.getDcard()!=""){
            UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
            //driver.setUid(userDao.getUid());
            driver.setUid(1);
            driverService.addDriver(driver);
            map.put("res","true");
            return map;
        }else {
            map.put("res","false");
            return map;
        }
    }

    /**
     * 删除驾驶员
     * @param driver
     *
     * @return
     */
    @RequestMapping(value = "deleteDriver", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteDriver(Driver driver){
        Map<String,Object> map=new HashMap<String,Object>();
        if (driver.getDname()!=null && driver.getDname()!=""
                && driver.getDphone()!=null && driver.getDphone()!=""
                && driver.getDcard()!=null && driver.getDcard()!=""){
            driverService.deleteDriver(driver);
            map.put("res","true");
            return map;
        }else {
            map.put("res","false");
            return map;
        }
    }

    /**
     * 查询驾驶员信息
     *
     * @return
     */
    @RequestMapping(value = "listDriver")
    @ResponseBody
    public Map<String,Object> listDriver(HttpServletRequest request,String dGrouping,String dName,String dPhone,String dCard,int page, int limit){
        UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
        //int uid = userDao.getUid();
        int uid = 1;
        int sum=(page-1)*limit;
        int count=driverService.endPageListDriver(uid,dGrouping,dName,dPhone,dCard);
        List<Driver> drivers = driverService.listDriver(uid,dGrouping,dName,dPhone,dCard,sum,limit);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data",drivers);
        return map;
    }

    /**
     * 修改驾驶员信息
     * @param driver
     *
     * @return
     */
    @RequestMapping(value = "updateDriver", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateDriver(Driver driver){
        Map<String,Object> map=new HashMap<String,Object>();
        if (driver.getDname()!=null && driver.getDname()!=""
                && driver.getDphone()!=null && driver.getDphone()!=""
                && driver.getDcard()!=null && driver.getDcard()!=""){
            driverService.updateDriver(driver);
            map.put("res","true");
            return map;
        }else {
            map.put("res","false");
            return map;
        }
    }

}
