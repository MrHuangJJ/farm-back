package com.lanzan.dao;

/**
 * 实时位置
 *
 */

import com.lanzan.entity.RealTime;

import java.util.List;

public interface RealTimeMapper {

    // 添加实时位置数据
    void addRealTime(RealTime realTime);

    // 查询车辆实时位置
    List<RealTime> listLocation();

}
