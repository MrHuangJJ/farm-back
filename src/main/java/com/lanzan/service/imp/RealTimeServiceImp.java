package com.lanzan.service.imp;

import com.lanzan.dao.RealTimeMapper;
import com.lanzan.entity.RealTime;
import com.lanzan.service.RealTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "realTimeService")
public class RealTimeServiceImp implements RealTimeService{

    @Autowired
    private RealTimeMapper realTimeMapper;

    // 添加实时位置数据
    public void addRealTime(RealTime realTime) {
        realTimeMapper.addRealTime(realTime);
    }

    // 查询车辆实时位置
    public List<RealTime> listLocation() {
        return realTimeMapper.listLocation();
    }


}
