package com.lanzan.dao;

import com.lanzan.entity.AgriculturalMachinery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 农机管理
 */
public interface AgriculturalMachineryMapper {

    // 添加农机
    void addAgriculturalMachinery(AgriculturalMachinery agriculturalMachinery);

    // 删除农机
    void deleteAgriculturalMachinery(AgriculturalMachinery agriculturalMachinery);

    // 查询农机
    List<AgriculturalMachinery> listAgriculturalMachinery(
            @Param(value = "am_licensePlate") String am_licensePlate,
            @Param(value = "am_grouping") String am_grouping,
            @Param(value = "am_SN") String am_SN,
            @Param(value = "pageNum") int pageNum,
            @Param(value = "pageSize") int pageSize);
    // 尾页
    int endPageListAgriculturalMachinery(@Param(value = "am_licensePlate") String am_licensePlate,
                                         @Param(value = "am_grouping") String am_grouping,
                                         @Param(value = "am_SN") String am_SN);

    // 修改农机
    void updateAgriculturalMachinery(AgriculturalMachinery agriculturalMachinery);

    // 根据am_SM修改农机状态
    void updateAmState(String am_state,String carId);

    //根据用户id查询农机
    List<AgriculturalMachinery> getAgriculturalMachinery(int uid);

}
