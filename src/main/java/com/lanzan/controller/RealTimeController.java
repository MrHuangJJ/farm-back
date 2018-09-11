package com.lanzan.controller;

import com.lanzan.entity.RealTime;
import com.lanzan.service.RealTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RealTimeController {

    @Autowired
    private RealTimeService realTimeService;

    /**
     * 查询车辆实时位置
     * @return
     */
    @RequestMapping(value = "listLocation")
    @ResponseBody
    public List<RealTime> listLocation(){
        List<RealTime> realTimes=realTimeService.listLocation();
        return realTimes;
    }


}
