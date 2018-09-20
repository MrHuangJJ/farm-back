package com.lanzan.service.imp;

import com.lanzan.dao.DriverMapper;
import com.lanzan.entity.Driver;
import com.lanzan.service.DriverService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "driverService")
public class DriverServiceImp implements DriverService {

    @Autowired
    private DriverMapper driverMapper;

    // 添加驾驶员
    public void addDriver(Driver driver) {
        driverMapper.addDriver(driver);
    }

    // 删除驾驶员
    public void deleteDriver(Driver driver) {
        driverMapper.deleteDriver(driver);
    }

    // 查询所以驾驶员信息
    public List<Driver> listDriver(
            @Param(value = "dGrouping") String dGrouping,
            @Param(value = "dName") String dName,
            @Param(value = "dPhone") String dPhone,
            @Param(value = "dCard") String dCard,
            @Param(value = "pageNum") int pageNum,
            @Param(value = "pageSize") int pageSize) {
        return driverMapper.listDriver(dGrouping,dName,dPhone,dCard,pageNum,pageSize);
    }
    //尾页
    public int endPageListDriver(@Param(value = "dGrouping") String dGrouping,
                                 @Param(value = "dName") String dName,
                                 @Param(value = "dPhone") String dPhone,
                                 @Param(value = "dCard") String dCard) {
        return driverMapper.endPageListDriver(dGrouping,dName,dPhone,dCard);
    }

    // 修改驾驶员信息
    public void updateDriver(Driver driver) {
        driverMapper.updateDriver(driver);
    }
}
