package com.lanzan.controller;

import com.lanzan.dto.CarsRealTimeDto;
import com.lanzan.service.CarsRealTimeDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarsRealTimeDtoController {

    @Autowired
    private CarsRealTimeDtoService carsRealTimeDtoService;

    /**
     * 查询车辆历史记录
     * @param
     *
     * @return
     */
    @RequestMapping(value = "listRealTime")
    @ResponseBody
    public List<CarsRealTimeDto> listCarsRealTimeDto(String carNO,String startTime,String endTime){
        List<CarsRealTimeDto> realTimes=carsRealTimeDtoService.listCarsRealTimeDto(carNO,startTime,endTime);
        return realTimes;
    }



}
