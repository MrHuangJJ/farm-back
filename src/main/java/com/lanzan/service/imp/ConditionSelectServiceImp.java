package com.lanzan.service.imp;

import com.lanzan.dao.ConditionSelectMapper;
import com.lanzan.entity.AgriculturalMachinery;
import com.lanzan.entity.Driver;
import com.lanzan.entity.HomeworkSeason;
import com.lanzan.service.ConditionSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "conditionSelectService")
public class ConditionSelectServiceImp implements ConditionSelectService {

    @Autowired
    private ConditionSelectMapper conditionSelectMapper;

    // 根据用户名查询uid
    public int unamegetuid(String uname) {
        return conditionSelectMapper.unamegetuid(uname);
    }

    // 查询农机车牌和农机编号
    public List<AgriculturalMachinery> getAmNameAndId() {
        return conditionSelectMapper.getAmNameAndId();
    }

    // 查询所以农机的am_SM终端号
    public List<AgriculturalMachinery> getAmSm() {
        return conditionSelectMapper.getAmSm();
    }

    // 查询驾驶员姓名与驾驶员编号
    public List<Driver> getDriverNameAndId() {
        return conditionSelectMapper.getDriverNameAndId();
    }

    // 查询作业季名称与作业季编号
    public List<HomeworkSeason> getHsNameAndId() {
        return conditionSelectMapper.getHsNameAndId();
    }
}
