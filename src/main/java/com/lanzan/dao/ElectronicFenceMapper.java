package com.lanzan.dao;

import com.lanzan.entity.ElectronicFence;

import java.util.List;

public interface ElectronicFenceMapper {

    // 添加电子围栏
    void addElectronicFence(ElectronicFence electronicFence);

    // 查询电子围栏数据
    List<ElectronicFence> listElectronicFence();

}
