package com.lanzan.service.imp;

import com.lanzan.dao.TaskMapper;
import com.lanzan.dao.UserRegisterMapper;
import com.lanzan.dto.TaskDto;
import com.lanzan.entity.Task;
import com.lanzan.entity.UserRegister;
import com.lanzan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "taskService")
public class TaskServiceImp implements TaskService {

    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private UserRegisterMapper userRegisterMapper;

    // 添加任务
    public void addTask(Task task) {
        taskMapper.addTask(task);
    }

    // 删除任务
    public void deleteTask(int tid) {
        taskMapper.deleteTask(tid);
    }

    // 查询任务
    public List<TaskDto> listTaskDto(int uid,String tGrouping, String am_SN, String am_licensePlate, String dName,
                                     String tType, String tAverage, String tMachineryType, String tAuditState, String tBeginTime,
                                     String tendTime, int pageNum, int pageSize) {
        //返回的农机集合
        List<TaskDto> TList = new ArrayList<TaskDto>();
        //第一步 根据传入的uid拿到用户的信息
        UserRegister userRegister = userRegisterMapper.getUserRegisterByUid(uid);
        //判断用户的类型是农机站还是合作社
        if (userRegister.getUr_type() == 0){
            //用户是农机站
            //用户是农机站，查询他所属的合作社或农机站
            List<UserRegister> userRegisters = userRegisterMapper.getUserRegistersByUid(userRegister.getUid());
            for (UserRegister register : userRegisters) {
                //自己调用自己，拿到作业季集合
                TList.addAll(listTaskDto(register.getUid(),tGrouping,am_SN,am_licensePlate,dName,tType,tAverage,tMachineryType,tAuditState,tBeginTime,tendTime,pageNum,pageSize));
            }
        }else{
            //用户是合作社,根据用户id查询作业季信息
            TList.addAll(taskMapper.listTaskDto(userRegister.getUid(),tGrouping,am_SN,am_licensePlate,dName,tType,tAverage,tMachineryType,tAuditState,tBeginTime,tendTime,pageNum,pageSize));
        }
        //将用户查询到的作业季信息添加到集合容器
        return TList;
    }
    // 尾页
    public int endPageListTaskDto(int uid,String tGrouping, String am_SN, String am_licensePlate, String dName, String tType, String tAverage, String tMachineryType, String tAuditState, String tBeginTime, String tendTime) {
        //尾页
        int count = 0;
        //第一步 根据传入的uid拿到用户的信息
        UserRegister userRegister = userRegisterMapper.getUserRegisterByUid(uid);
        //判断用户的类型是农机站还是合作社
        if (userRegister.getUr_type() == 0){
            //用户是农机站
            //用户是农机站，查询他所属的合作社或农机站
            List<UserRegister> userRegisters = userRegisterMapper.getUserRegistersByUid(userRegister.getUid());
            for (UserRegister register : userRegisters) {
                //自己调用自己，拿到农机的数量
                count = count + endPageListTaskDto(register.getUid(),tGrouping,am_SN,am_licensePlate,dName,tType,tAverage,tMachineryType,tAuditState,tBeginTime,tendTime);
            }
        }else{
            //用户是合作社,根据用户id查询农机数量
            count = count + taskMapper.endPageListTaskDto(userRegister.getUid(),tGrouping,am_SN,am_licensePlate,dName,tType,tAverage,tMachineryType,tAuditState,tBeginTime,tendTime);
        }
        //将用户查询到的作业季信息添加到集合容器
        return count;
    }
}
