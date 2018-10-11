package com.lanzan.dao;

import com.lanzan.entity.AgriculturalMachinery;
import com.lanzan.entity.Driver;
import com.lanzan.entity.HomeworkSeason;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 根据条件查询 or 查询单个
 *
 */
public interface ConditionSelectMapper {

    // 根据用户名查询uid
    int unamegetuid(String uname);

    // 查询农机车牌和农机编号
    List<AgriculturalMachinery> getAmNameAndId(@Param(value = "uid") int uid);

    // 查询所以农机的am_SM终端号
    List<AgriculturalMachinery> getAmSm();

    // 查询驾驶员姓名与驾驶员编号
    List<Driver> getDriverNameAndId(@Param(value = "uid") int uid);

    // 查询作业季名称与作业季编号
    List<HomeworkSeason> getHsNameAndId(@Param(value = "uid") int uid);

}
