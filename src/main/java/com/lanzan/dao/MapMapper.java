package com.lanzan.dao;

import com.lanzan.entity.AgriculturalMachinery;

import java.util.List;

/**
 *
 * 地图
 */
public interface MapMapper {

    // 查询在线农机
    List<AgriculturalMachinery> getOnLineAm();

    // 查询离线农机
    List<AgriculturalMachinery> getOffLineAm();

    // 根据分组查询农机
    List<AgriculturalMachinery> getGroupingAm(String am_grouping);

    // 地图农机详细信息查询


}
