package com.lanzan.service;

import com.lanzan.entity.Driver;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 驾驶员管理
 */
public interface DriverService {

    // 添加驾驶员
    void addDriver(Driver driver);

    // 删除驾驶员
    void deleteDriver(Driver driver);

    // 查询所以驾驶员信息
    List<Driver> listDriver(
            @Param(value = "dGrouping") String dGrouping,
            @Param(value = "dName") String dName,
            @Param(value = "dPhone") String dPhone,
            @Param(value = "dCard") String dCard,
            @Param(value = "pageNum") int pageNum,
            @Param(value = "pageSize") int pageSize);
    // 尾页
    int endPageListDriver(@Param(value = "dGrouping") String dGrouping,
                          @Param(value = "dName") String dName,
                          @Param(value = "dPhone") String dPhone,
                          @Param(value = "dCard") String dCard);

    // 修改驾驶员信息
    void updateDriver(Driver driver);

}
