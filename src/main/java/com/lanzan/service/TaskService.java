package com.lanzan.service;

import com.lanzan.dto.TaskDto;
import com.lanzan.entity.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 任务
 */
public interface TaskService {

    // 任务添加
    void addTask(Task task);

    // 任务删除
    void deleteTask(int tid);

    // 任务查询
    List<TaskDto> listTaskDto(
            @Param(value = "uid") int uid,
            @Param(value = "tGrouping") String tGrouping,
            @Param(value = "am_SN") String am_SN,
            @Param(value = "am_licensePlate") String am_licensePlate,
            @Param(value = "dName") String dName,
            @Param(value = "tType") String tType,
            @Param(value = "tAverage") String tAverage,
            @Param(value = "tMachineryType") String tMachineryType,
            @Param(value = "tAuditState") String tAuditState,
            @Param(value = "tBeginTime") String tBeginTime,
            @Param(value = "tendTime") String tendTime,
            @Param(value = "pageNum") int pageNum,
            @Param(value = "pageSize") int pageSize
    );
    //尾页
    int endPageListTaskDto(
            @Param(value = "uid") int uid,
            @Param(value = "tGrouping") String tGrouping,
            @Param(value = "am_SN") String am_SN,
            @Param(value = "am_licensePlate") String am_licensePlate,
            @Param(value = "dName") String dName,
            @Param(value = "tType") String tType,
            @Param(value = "tAverage") String tAverage,
            @Param(value = "tMachineryType") String tMachineryType,
            @Param(value = "tAuditState") String tAuditState,
            @Param(value = "tBeginTime") String tBeginTime,
            @Param(value = "tendTime") String tendTime
    );

}
