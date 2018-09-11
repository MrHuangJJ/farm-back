package com.lanzan.service.imp;

import com.lanzan.dao.ElectronicFenceMapper;
import com.lanzan.entity.ElectronicFence;
import com.lanzan.service.ElectronicFenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "electronicFenceService")
public class ElectronicFenceServiceImp implements ElectronicFenceService{

    @Autowired
    private ElectronicFenceMapper electronicFenceMapper;

    // 添加电子围栏
    public void addElectronicFence(ElectronicFence electronicFence) {
        electronicFenceMapper.addElectronicFence(electronicFence);
    }

    public List<ElectronicFence> listElectronicFence() {
        return electronicFenceMapper.listElectronicFence();
    }
}
