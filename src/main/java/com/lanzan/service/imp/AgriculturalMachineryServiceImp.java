package com.lanzan.service.imp;

import com.lanzan.dao.AgriculturalMachineryMapper;
import com.lanzan.entity.AgriculturalMachinery;
import com.lanzan.service.AgriculturalMachineryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "agriculturalMachineryService")
public class AgriculturalMachineryServiceImp implements AgriculturalMachineryService{

    @Autowired
    private AgriculturalMachineryMapper agriculturalMachineryMapper;

    // 添加农机
    public void addAgriculturalMachinery(AgriculturalMachinery agriculturalMachinery) {
        agriculturalMachineryMapper.addAgriculturalMachinery(agriculturalMachinery);
    }

    // 删除农机
    public void deleteAgriculturalMachinery(AgriculturalMachinery agriculturalMachinery) {
        agriculturalMachineryMapper.deleteAgriculturalMachinery(agriculturalMachinery);
    }

    // 查询农机
    public List<AgriculturalMachinery> listAgriculturalMachinery(
            @Param(value = "am_licensePlate") String am_licensePlate,
            @Param(value = "am_grouping") String am_grouping,
            @Param(value = "am_SN") String am_SN,
            @Param(value = "pageNum") int pageNum,
            @Param(value = "pageSize") int pageSize) {
        return agriculturalMachineryMapper.listAgriculturalMachinery(am_licensePlate,am_grouping,am_SN,pageNum,pageSize);
    }
    // 尾页
    public int endPageListAgriculturalMachinery(@Param(value = "am_licensePlate") String am_licensePlate,
                                                @Param(value = "am_grouping") String am_grouping,
                                                @Param(value = "am_SN") String am_SN) {
        return agriculturalMachineryMapper.endPageListAgriculturalMachinery(am_licensePlate,am_grouping,am_SN);
    }

    // 修改农机
    public void updateAgriculturalMachinery(AgriculturalMachinery agriculturalMachinery) {
        agriculturalMachineryMapper.updateAgriculturalMachinery(agriculturalMachinery);
    }

}
