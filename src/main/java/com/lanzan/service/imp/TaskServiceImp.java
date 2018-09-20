package com.lanzan.service.imp;

import com.lanzan.dao.TaskMapper;
import com.lanzan.dto.TaskDto;
import com.lanzan.entity.Task;
import com.lanzan.service.TaskService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "taskService")
public class TaskServiceImp implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    // 添加任务
    public void addTask(Task task) {
        taskMapper.addTask(task);
    }

    // 删除任务
    public void deleteTask(int tid) {
        taskMapper.deleteTask(tid);
    }

    // 查询任务
    public List<TaskDto> listTaskDto(@Param(value = "tGrouping") String tGrouping,
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
                                     @Param(value = "pageSize") int pageSize) {
        return taskMapper.listTaskDto(tGrouping,am_SN,am_licensePlate,dName,tType,tAverage,tMachineryType,tAuditState,tBeginTime,tendTime,pageNum,pageSize);
    }
    // 尾页
    public int endPageListTaskDto(String tGrouping, String am_SN, String am_licensePlate, String dName, String tType, String tAverage, String tMachineryType, String tAuditState, String tBeginTime, String tendTime) {
        return taskMapper.endPageListTaskDto(tGrouping,am_SN,am_licensePlate,dName,tType,tAverage,tMachineryType,tAuditState,tBeginTime,tendTime);
    }
}
