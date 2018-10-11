package com.lanzan.service.imp;

import com.lanzan.dao.ConditionSelectMapper;
import com.lanzan.dao.UserRegisterMapper;
import com.lanzan.entity.AgriculturalMachinery;
import com.lanzan.entity.Driver;
import com.lanzan.entity.HomeworkSeason;
import com.lanzan.entity.UserRegister;
import com.lanzan.service.ConditionSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "conditionSelectService")
public class ConditionSelectServiceImp implements ConditionSelectService {

    @Autowired
    private ConditionSelectMapper conditionSelectMapper;
    @Autowired
    private UserRegisterMapper userRegisterMapper;


    /**
     *  根据用户名查询uid
     * @param uname
     * @return
     */
    public int unamegetuid(String uname) {
        return conditionSelectMapper.unamegetuid(uname);
    }

    /**
     * 查询农机车牌和农机编号
     * @param uid
     * @return
     */
    public List<AgriculturalMachinery> getAmNameAndId(int uid) {
        //返回的农机集合
        List<AgriculturalMachinery> AsListGet = new ArrayList<AgriculturalMachinery>();
        //第一步 根据传入的uid拿到用户的信息
        UserRegister userRegister = userRegisterMapper.getUserRegisterByUid(uid);
        //判断用户的类型是农机站还是合作社
        if (userRegister.getUr_type() == 0){
            //用户是农机站
            //用户是农机站，查询他所属的合作社或农机站
            List<UserRegister> userRegisters = userRegisterMapper.getUserRegistersByUid(userRegister.getUid());
            for (UserRegister register : userRegisters) {
                //自己调用自己，拿到农机集合
                AsListGet.addAll(getAmNameAndId(register.getUid()));
            }
        }else{
            //用户是合作社,根据用户id查询农机信息
            AsListGet.addAll(conditionSelectMapper.getAmNameAndId(userRegister.getUid()));
        }
        //将用户查询到的农机信息添加到集合容器
        return AsListGet;
    }

    /**
     * 查询所以农机的am_SM终端号
     * @return
     */
    public List<AgriculturalMachinery> getAmSm() {
        return conditionSelectMapper.getAmSm();
    }

    /**
     * 查询驾驶员姓名与驾驶员编号
     * @param uid
     * @return
     */
    public List<Driver> getDriverNameAndId(int uid) {
        //返回的农机集合
        List<Driver> DListGet = new ArrayList<Driver>();
        //第一步 根据传入的uid拿到用户的信息
        UserRegister userRegister = userRegisterMapper.getUserRegisterByUid(uid);
        //判断用户的类型是农机站还是合作社
        if (userRegister.getUr_type() == 0){
            //用户是农机站
            //用户是农机站，查询他所属的合作社或农机站
            List<UserRegister> userRegisters = userRegisterMapper.getUserRegistersByUid(userRegister.getUid());
            for (UserRegister register : userRegisters) {
                //自己调用自己，拿到农机集合
                DListGet.addAll(getDriverNameAndId(register.getUid()));
            }
        }else{
            //用户是合作社,根据用户id查询农机信息
            DListGet.addAll(conditionSelectMapper.getDriverNameAndId(userRegister.getUid()));
        }
        //将用户查询到的农机信息添加到集合容器
        return DListGet;
    }

    /**
     * 查询作业季名称与作业季编号
     * @param uid
     * @return
     */
    public List<HomeworkSeason> getHsNameAndId(int uid) {
        //返回的农机集合
        List<HomeworkSeason> HsListGet = new ArrayList<HomeworkSeason>();
        //第一步 根据传入的uid拿到用户的信息
        UserRegister userRegister = userRegisterMapper.getUserRegisterByUid(uid);
        //判断用户的类型是农机站还是合作社
        if (userRegister.getUr_type() == 0){
            //用户是农机站
            //用户是农机站，查询他所属的合作社或农机站
            List<UserRegister> userRegisters = userRegisterMapper.getUserRegistersByUid(userRegister.getUid());
            for (UserRegister register : userRegisters) {
                //自己调用自己，拿到农机集合
                HsListGet.addAll(getHsNameAndId(register.getUid()));
            }
        }else{
            //用户是合作社,根据用户id查询农机信息
            HsListGet.addAll(conditionSelectMapper.getHsNameAndId(userRegister.getUid()));
        }
        //将用户查询到的农机信息添加到集合容器
        return HsListGet;
    }
}
