package com.lanzan.controller;

import com.lanzan.dto.UserDto;
import com.lanzan.entity.AgriculturalMachinery;
import com.lanzan.entity.Task;
import com.lanzan.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    /**
     * 农机总数
     *
     * @return
     */
    @RequestMapping(value = "listStatisticsAgriculturalMachinery")
    @ResponseBody
    public Map<String,Object> listStatisticsAgriculturalMachinery(HttpServletRequest request, String am_grouping, int page, int limit){
        UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
        //int uid = userDao.getUid();
        int uid = 3;
        int sum=(page-1)*limit;
        int count=statisticsService.endPageListStatisticsAgriculturalMachinery(uid,am_grouping);
        List<AgriculturalMachinery> SAgriculturalMachineries = statisticsService.listStatisticsAgriculturalMachinery(uid,am_grouping,sum,limit);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data",SAgriculturalMachineries);
        return map;
    }

    /**
     * 当前在线农机
     * @param request
     * @return
     */
    @RequestMapping(value = "onLineAm")
    @ResponseBody
    public Map<String,Object> onLineAm(HttpServletRequest request){
        UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
        //int uid = userDao.getUid();
        int uid = 3;
        int onLineCount = statisticsService.onLineAm(uid);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("res",onLineCount);
        return map;
    }

    /**
     * 当日在线农机
     * @param request
     * @return
     */
    @RequestMapping(value = "toOneOnLineAm")
    @ResponseBody
    public Map<String,Object> toOneOnLineAm(HttpServletRequest request){
        UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
        //int uid = userDao.getUid();
        int uid = 1;
        int onLineCount = statisticsService.toOneOnLineAm(uid);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("res",onLineCount);
        return map;
    }

    /**
     * 当月在线农机
     * @param request
     * @return
     */
    @RequestMapping(value = "toMonthOnLineAm")
    @ResponseBody
    public Map<String,Object> toMonthOnLineAm(HttpServletRequest request){
        UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
        //int uid = userDao.getUid();
        int uid = 1;
        int onLineCount = statisticsService.toMonthOnLineAm(uid);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("res",onLineCount);
        return map;
    }

    /**
     * 长期离线
     * @param request
     * @return
     */
    @RequestMapping(value = "offLineAm")
    @ResponseBody
    public Map<String,Object> offLineAm(HttpServletRequest request){
        UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
        //int uid = userDao.getUid();
        int uid = 1;
        int onLineCount = statisticsService.offLineAm(uid);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("res",onLineCount);
        return map;
    }

    /**
     * 任务统计
     * @param request
     * @param years
     * @param tGrouping
     * @param tType
     * @param tBeginTime
     * @param tendTime
     * @return
     */
    @RequestMapping(value = "listTaskStatistics")
    @ResponseBody
    public Map<String,Object> listTaskStatistics(HttpServletRequest request,String years,String tGrouping,String tType,String tBeginTime,String tendTime){
        if (years != null && years != ""){
            tBeginTime=years+"-01-01";
            tendTime=years+"-12-31";
        }
        UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
        //int uid = userDao.getUid();
        int uid = 1;
        List<Task> tasks = statisticsService.listTaskStatistics(uid,tGrouping,tType,tBeginTime,tendTime);
        double sum = 0;
        for (Task task : tasks) {
            sum += task.getTarea();
        }
        System.out.println(sum);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("data", tasks);
        map.put("sum", sum);
        return map;
    }

}
