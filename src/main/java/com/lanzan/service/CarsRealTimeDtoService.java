package com.lanzan.service;

import com.lanzan.dto.CarsRealTimeDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarsRealTimeDtoService {

    // 历史轨迹
    List<CarsRealTimeDto> listCarsRealTimeDto(@Param(value = "carNO") String carNO, @Param(value = "startTime") String startTime, @Param(value = "endTime") String endTime);

}
