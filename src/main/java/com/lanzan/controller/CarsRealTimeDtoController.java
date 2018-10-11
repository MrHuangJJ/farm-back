package com.lanzan.controller;

import com.lanzan.dto.CarsRealTimeDto;
import com.lanzan.dto.UserDto;
import com.lanzan.dto.HistoryDto;
import com.lanzan.service.CarsRealTimeDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CarsRealTimeDtoController {

    @Autowired
    private CarsRealTimeDtoService carsRealTimeDtoService;

    /**
     * 历史轨迹数据列表接口
     * @param request
     * @param am_licensePlate
     * @param am_SN
     * @param beginTime
     * @param endTime
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "listHistoryDto")
    @ResponseBody
    public Map<String,Object> listHistoryDto(HttpServletRequest request, String am_licensePlate, String am_SN,String beginTime, String endTime, int page, int limit){
        UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
        //int uid = userDao.getUid();
        int uid = 1;
        int sum=(page-1)*limit;
        int count=carsRealTimeDtoService.endPageListHistoryDto(uid,am_licensePlate,am_SN,beginTime,endTime);
        List<HistoryDto> historyDtos = carsRealTimeDtoService.listHistoryDto(uid,am_licensePlate,am_SN,beginTime,endTime,sum,limit);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data",historyDtos);
        return map;
    }

    /**
     * 历史记录
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
