package com.lanzan.service.imp;

import com.lanzan.dao.HomeworkSeasonMapper;
import com.lanzan.dao.UserRegisterMapper;
import com.lanzan.entity.HomeworkSeason;
import com.lanzan.entity.UserRegister;
import com.lanzan.service.HomeworkSeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "homeworkSeasonService")
public class HomeworkSeasonServiceImp implements HomeworkSeasonService {

    @Autowired
    private HomeworkSeasonMapper homeworkSeasonMapper;
    @Autowired
    private UserRegisterMapper userRegisterMapper;

    // 添加作业季
    public void addHomeworkSeason(HomeworkSeason homeworkSeason) {
        homeworkSeasonMapper.addHomeworkSeason(homeworkSeason);
    }

    // 删除作业季
    public void deleteHomeworkSeason(HomeworkSeason homeworkSeason) {
        homeworkSeasonMapper.deleteHomeworkSeason(homeworkSeason);
    }

    // 查询作业季
    public List<HomeworkSeason> listHomeworkSeason(
            int uid,String hs_grouping, String hs_type, String hs_beginTime, String hs_endTime, int pageNum, int pageSize) {
        //返回的农机集合
        List<HomeworkSeason> HsList = new ArrayList<HomeworkSeason>();
        //第一步 根据传入的uid拿到用户的信息
        UserRegister userRegister = userRegisterMapper.getUserRegisterByUid(uid);
        //判断用户的类型是农机站还是合作社
        if (userRegister.getUr_type() == 0){
            //用户是农机站
            //用户是农机站，查询他所属的合作社或农机站
            List<UserRegister> userRegisters = userRegisterMapper.getUserRegistersByUid(userRegister.getUid());
            for (UserRegister register : userRegisters) {
                //自己调用自己，拿到作业季集合
                HsList.addAll(listHomeworkSeason(register.getUid(),hs_grouping,hs_type,hs_beginTime,hs_endTime,pageNum,pageSize));
            }
        }else{
            //用户是合作社,根据用户id查询作业季信息
            HsList.addAll(homeworkSeasonMapper.listHomeworkSeason(userRegister.getUid(),hs_grouping,hs_type,hs_beginTime,hs_endTime,pageNum,pageSize));
        }
        //将用户查询到的作业季信息添加到集合容器
        return HsList;
    }
    // 尾页
    public int endPageListHomeworkSeason(int uid, String hs_grouping, String hs_type, String hs_beginTime, String hs_endTime) {
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
                count = count + endPageListHomeworkSeason(register.getUid(),hs_grouping,hs_type,hs_beginTime,hs_endTime);
            }
        }else{
            //用户是合作社,根据用户id查询农机数量
            count = count + homeworkSeasonMapper.endPageListHomeworkSeason(userRegister.getUid(),hs_grouping,hs_type,hs_beginTime,hs_endTime);
        }
        //将用户查询到的作业季信息添加到集合容器
        return count;
    }

    // 修改作业季
    public void updateHomeworkSeason(HomeworkSeason homeworkSeason) {
        homeworkSeasonMapper.updateHomeworkSeason(homeworkSeason);
    }
}
