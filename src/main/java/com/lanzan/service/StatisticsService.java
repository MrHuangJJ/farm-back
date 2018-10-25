package com.lanzan.service;

import com.lanzan.entity.AgriculturalMachinery;
import com.lanzan.entity.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 统计
 */
public interface StatisticsService {

    // 农机总数
    List<AgriculturalMachinery> listStatisticsAgriculturalMachinery(
            @Param(value = "uid") int uid,
            @Param(value = "am_grouping") String am_grouping,
            @Param(value = "pageNum") int pageNum,
            @Param(value = "pageSize") int pageSize);
    // 尾页
    int endPageListStatisticsAgriculturalMachinery(@Param(value = "uid") int uid, @Param(value = "am_grouping") String am_grouping);

    // 当前在线
    int onLineAm(@Param(value = "uid") int uid);

    // 当日在线
    int toOneOnLineAm(@Param(value = "uid") int uid);

    // 当月在线
    int toMonthOnLineAm(@Param(value = "uid") int uid);

    // 长期离线
    int offLineAm(@Param(value = "uid") int uid);

    // 任务统计
    List<Task> listTaskStatistics(@Param(value = "uid") int uid,
                                  @Param(value = "tGrouping") String tGrouping,
                                  @Param(value = "tType") String tType,
                                  @Param(value = "tBeginTime") String tBeginTime,
                                  @Param(value = "tendTime") String tendTime);


}
