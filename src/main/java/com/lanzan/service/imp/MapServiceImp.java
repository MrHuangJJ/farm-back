package com.lanzan.service.imp;

import com.lanzan.dao.MapMapper;
import com.lanzan.dto.MapDto;
import com.lanzan.entity.AgriculturalMachinery;
import com.lanzan.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "mapService")
public class MapServiceImp implements MapService {

    @Autowired
    private MapMapper mapMapper;

    // 查询在线农机
    public List<AgriculturalMachinery> getOnLineAm() {
        return mapMapper.getOnLineAm();
    }

    // 查询离线农机
    public List<AgriculturalMachinery> getOffLineAm() {
        return mapMapper.getOffLineAm();
    }

    // 根据分组查询农机
    public List<AgriculturalMachinery> getGroupingAm(String am_grouping) {
        return mapMapper.getGroupingAm(am_grouping);
    }

    // 地图农机详细信息查询(根据农机编号查询)
    public MapDto getMapDto(String carId) {
        return mapMapper.getMapDto(carId);
    }
}
