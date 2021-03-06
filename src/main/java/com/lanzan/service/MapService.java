package com.lanzan.service;

import com.lanzan.dto.MapDto;
import com.lanzan.entity.AgriculturalMachinery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 地图
 */
public interface MapService {

    // 查询在线农机
    List<AgriculturalMachinery> getOnLineAm(@Param(value = "uid") int uid);

    // 查询离线农机
    List<AgriculturalMachinery> getOffLineAm(@Param(value = "uid") int uid);

    // 根据分组查询农机
    List<AgriculturalMachinery> getGroupingAm(@Param(value = "uid") int uid,@Param(value = "am_grouping") String am_grouping);

    // 地图农机详细信息查询(根据农机编号查询)
    MapDto getMapDto(String carId);

}
