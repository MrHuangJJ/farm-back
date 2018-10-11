package com.lanzan.controller;

import com.lanzan.dto.UserDto;
import com.lanzan.entity.Task;
import com.lanzan.dto.TaskDto;
import com.lanzan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * 添加任务
     * @param task
     *
     * @return
     */
    @RequestMapping(value = "addTask", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addTask(HttpServletRequest request, Task task){
        Map<String,Object> map=new HashMap<String,Object>();
        if (task.getAm_id()!=0 && task.getDid()!=0 && task.getHs_id()!=0
                && task.getTmachineryType()!=null && task.getTmachineryType()!=""){
            task.setTauditState("待审核");
            UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
            //agriculturalMachinery.setUid(userDao.getUid());
            task.setUid(1);
            taskService.addTask(task);
            map.put("res","true");
            return map;
        }else {
            map.put("res","false");
            return map;
        }
    }

    /**
     * 删除任务
     * @param tid
     * @return
     */
    @RequestMapping(value = "deleteTask", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object>  deleteTask(int tid){
        Map<String,Object> map=new HashMap<String,Object>();
        if (tid!=0){
            taskService.deleteTask(tid);
            map.put("res","true");
            return map;
        }else {
            map.put("res","false");
            return map;
        }
    }

    /**
     * 查询任务
     *
     * @return
     */
    @RequestMapping(value = "listTaskDto")
    @ResponseBody
    public Map<String,Object> listTaskDto(HttpServletRequest request,String tGrouping, String am_SN, String am_licensePlate, String dName, String tType, String tAverage, String tMachineryType, String tAuditState, String tBeginTime, String tendTime,int page, int limit){
        UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
        //int uid = userDao.getUid();
        int uid = 1;
        int sum=(page-1)*limit;
        int count=taskService.endPageListTaskDto(uid,tGrouping,am_SN,am_licensePlate,dName,tType,tAverage,tMachineryType,tAuditState,tBeginTime,tendTime);
        List<TaskDto> taskDtos = taskService.listTaskDto(uid,tGrouping,am_SN,am_licensePlate,dName,tType,tAverage,tMachineryType,tAuditState,tBeginTime,tendTime,sum,limit);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data",taskDtos);
        return map;
    }


}
