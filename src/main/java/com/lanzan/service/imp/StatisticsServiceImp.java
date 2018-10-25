package com.lanzan.service.imp;

import com.lanzan.dao.StatisticsMapper;
import com.lanzan.dao.UserRegisterMapper;
import com.lanzan.entity.AgriculturalMachinery;
import com.lanzan.entity.Task;
import com.lanzan.entity.UserRegister;
import com.lanzan.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "statisticsService")
public class StatisticsServiceImp implements StatisticsService {

    @Autowired
    private StatisticsMapper statisticsMapper;
    @Autowired
    private UserRegisterMapper userRegisterMapper;

    // 查询农机
    public List<AgriculturalMachinery> listStatisticsAgriculturalMachinery(int uid, String am_grouping, int pageNum, int pageSize) {
        //返回的农机集合
        List<AgriculturalMachinery> SAmList = new ArrayList<AgriculturalMachinery>();
        //第一步 根据传入的uid拿到用户的信息
        UserRegister userRegister = userRegisterMapper.getUserRegisterByUid(uid);
        //判断用户的类型是农机站还是合作社
        if (userRegister.getUr_type() == 0){
            //用户是农机站
            //用户是农机站，查询他所属的合作社或农机站
            List<UserRegister> userRegisters = userRegisterMapper.getUserRegistersByUid(userRegister.getUid());
            for (UserRegister register : userRegisters) {
                //自己调用自己，拿到农机集合
                SAmList.addAll(listStatisticsAgriculturalMachinery(register.getUid(),am_grouping,pageNum,pageSize));
            }
        }else{
            //用户是合作社,根据用户id查询农机信息
            SAmList.addAll(statisticsMapper.listStatisticsAgriculturalMachinery(userRegister.getUid(),am_grouping,pageNum,pageSize));
        }
        //将用户查询到的农机信息添加到集合容器
        return SAmList;
    }
    // 尾页
    public int endPageListStatisticsAgriculturalMachinery(int uid, String am_grouping) {
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
                count = count + endPageListStatisticsAgriculturalMachinery(register.getUid(),am_grouping);
            }
        }else{
            //用户是合作社,根据用户id查询农机数量
            count = count + statisticsMapper.endPageListStatisticsAgriculturalMachinery(userRegister.getUid(),am_grouping);
        }
        //将用户查询到的农机信息添加到集合容器
        return count;
    }

    // 在线农机
    public int onLineAm(int uid) {
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
                count = count + onLineAm(register.getUid());
            }
        }else{
            //用户是合作社,根据用户id查询农机数量
            count = count + statisticsMapper.onLineAm(userRegister.getUid());
        }
        //将用户查询到的农机信息添加到集合容器
        return count;
    }

    // 当日在线农机
    public int toOneOnLineAm(int uid) {
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
                count = count + toOneOnLineAm(register.getUid());
            }
        }else{
            //用户是合作社,根据用户id查询农机数量
            count = count + statisticsMapper.toOneOnLineAm(userRegister.getUid());
        }
        //将用户查询到的农机信息添加到集合容器
        return count;
    }

    // 当月在线农机
    public int toMonthOnLineAm(int uid) {
        int count = 0;
        //第一步 根据传入的uid拿到用户的信息
        UserRegister userRegister = userRegisterMapper.getUserRegisterByUid(uid);
        //判断用户的类型是农机站还是合作社
        if (userRegister.getUr_type() == 0){
            List<UserRegister> userRegisters = userRegisterMapper.getUserRegistersByUid(userRegister.getUid());
            for (UserRegister register : userRegisters) {
                //自己调用自己，拿到农机的数量
                count = count + toMonthOnLineAm(register.getUid());
            }
        }else{
            count = count + statisticsMapper.toMonthOnLineAm(userRegister.getUid());
        }
        //将用户查询到的农机信息添加到集合容器
        return count;
    }

    // 长期离线
    public int offLineAm(int uid) {
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
                count = count + offLineAm(register.getUid());
            }
        }else{
            //用户是合作社,根据用户id查询农机数量
            count = count + statisticsMapper.offLineAm(userRegister.getUid());
        }
        //将用户查询到的农机信息添加到集合容器
        return count;
    }

    // 任务统计
    public List<Task> listTaskStatistics(int uid, String tGrouping, String tType, String tBeginTime, String tendTime) {
        //返回的农机集合
        List<Task> TaskList = new ArrayList<Task>();
        //第一步 根据传入的uid拿到用户的信息
        UserRegister userRegister = userRegisterMapper.getUserRegisterByUid(uid);
        //判断用户的类型是农机站还是合作社
        if (userRegister.getUr_type() == 0){
            //用户是农机站
            //用户是农机站，查询他所属的合作社或农机站
            List<UserRegister> userRegisters = userRegisterMapper.getUserRegistersByUid(userRegister.getUid());
            for (UserRegister register : userRegisters) {
                //自己调用自己，拿到农机集合
                TaskList.addAll(listTaskStatistics(register.getUid(),tGrouping,tType,tBeginTime,tendTime));
            }
        }else{
            //用户是合作社,根据用户id查询农机信息
            TaskList.addAll(statisticsMapper.listTaskStatistics(userRegister.getUid(),tGrouping,tType,tBeginTime,tendTime));
        }
        return TaskList;
    }


}
