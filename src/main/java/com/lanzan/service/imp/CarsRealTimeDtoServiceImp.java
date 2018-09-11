package com.lanzan.service.imp;

import com.lanzan.dao.CarsRealTimeDtoMapper;
import com.lanzan.dto.CarsRealTimeDto;
import com.lanzan.service.CarsRealTimeDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "carsRealTimeDtoService")
public class CarsRealTimeDtoServiceImp implements CarsRealTimeDtoService{

    @Autowired
    private CarsRealTimeDtoMapper carsRealTimeDtoMapper;

    // 历史轨迹
    public List<CarsRealTimeDto> listCarsRealTimeDto(String carNO,String startTime,String endTime) {
        if (carNO!=null && carNO!="" && startTime!=null && startTime!="" && endTime!=null && endTime!=""){
            return carsRealTimeDtoMapper.listCarsRealTimeDto(carNO,startTime,endTime);
        }else {
            return null;
        }
    }




}
