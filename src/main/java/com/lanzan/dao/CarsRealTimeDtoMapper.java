package com.lanzan.dao;

import com.lanzan.dto.CarsRealTimeDto;
import com.lanzan.dto.HistoryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 历史轨迹
 */
public interface CarsRealTimeDtoMapper {

    // 任务历史轨迹列表
    List<HistoryDto> listHistoryDto(
            @Param(value = "uid")int uid,
            @Param(value = "am_licensePlate")String am_licensePlate,
            @Param(value = "am_SN")String am_SN,
            @Param(value = "beginTime")String beginTime,
            @Param(value = "endTime")String endTime,
            @Param(value = "pageNum") int pageNum,
            @Param(value = "pageSize") int pageSize);
    //尾页
    int endPageListHistoryDto(
            @Param(value = "uid") int uid,
            @Param(value = "am_licensePlate")String am_licensePlate,
            @Param(value = "am_SN")String am_SN,
            @Param(value = "beginTime")String beginTime,
            @Param(value = "endTime")String endTime);

    // 历史轨迹数据
    List<CarsRealTimeDto> listCarsRealTimeDto(@Param(value = "carNO")String carNO,@Param(value = "startTime")String startTime,@Param(value = "endTime")String endTime);



}
