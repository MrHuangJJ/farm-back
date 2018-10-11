package com.lanzan.service.imp;

import com.lanzan.dao.MapMapper;
import com.lanzan.dao.UserRegisterMapper;
import com.lanzan.dto.MapDto;
import com.lanzan.entity.AgriculturalMachinery;
import com.lanzan.entity.UserRegister;
import com.lanzan.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "mapService")
public class MapServiceImp implements MapService {

    @Autowired
    private MapMapper mapMapper;
    @Autowired
    private UserRegisterMapper userRegisterMapper;

    // 查询在线农机
    public List<AgriculturalMachinery> getOnLineAm(int uid) {
        //返回的农机集合
        List<AgriculturalMachinery> AmList = new ArrayList<AgriculturalMachinery>();
        //第一步 根据传入的uid拿到用户的信息
        UserRegister userRegister = userRegisterMapper.getUserRegisterByUid(uid);
        //判断用户的类型是农机站还是合作社
        if (userRegister.getUr_type() == 0){
            //用户是农机站
            //用户是农机站，查询他所属的合作社或农机站
            List<UserRegister> userRegisters = userRegisterMapper.getUserRegistersByUid(userRegister.getUid());
            for (UserRegister register : userRegisters) {
                //自己调用自己，拿到农机集合
                AmList.addAll(getOnLineAm(register.getUid()));
            }
        }else{
            //用户是合作社,根据用户id查询农机信息
            AmList.addAll(mapMapper.getOnLineAm(userRegister.getUid()));
        }
        //将用户查询到的农机信息添加到集合容器
        return AmList;
    }

    // 查询离线农机
    public List<AgriculturalMachinery> getOffLineAm(int uid) {
        //返回的农机集合
        List<AgriculturalMachinery> AmList = new ArrayList<AgriculturalMachinery>();
        //第一步 根据传入的uid拿到用户的信息
        UserRegister userRegister = userRegisterMapper.getUserRegisterByUid(uid);
        //判断用户的类型是农机站还是合作社
        if (userRegister.getUr_type() == 0){
            //用户是农机站
            //用户是农机站，查询他所属的合作社或农机站
            List<UserRegister> userRegisters = userRegisterMapper.getUserRegistersByUid(userRegister.getUid());
            for (UserRegister register : userRegisters) {
                //自己调用自己，拿到农机集合
                AmList.addAll(getOffLineAm(register.getUid()));
            }
        }else{
            //用户是合作社,根据用户id查询农机信息
            AmList.addAll(mapMapper.getOffLineAm(userRegister.getUid()));
        }
        //将用户查询到的农机信息添加到集合容器
        return AmList;
    }

    // 根据分组查询农机
    public List<AgriculturalMachinery> getGroupingAm(int uid,String am_grouping) {
        //返回的农机集合
        List<AgriculturalMachinery> AmList = new ArrayList<AgriculturalMachinery>();
        //第一步 根据传入的uid拿到用户的信息
        UserRegister userRegister = userRegisterMapper.getUserRegisterByUid(uid);
        //判断用户的类型是农机站还是合作社
        if (userRegister.getUr_type() == 0){
            //用户是农机站
            //用户是农机站，查询他所属的合作社或农机站
            List<UserRegister> userRegisters = userRegisterMapper.getUserRegistersByUid(userRegister.getUid());
            for (UserRegister register : userRegisters) {
                //自己调用自己，拿到农机集合
                AmList.addAll(getGroupingAm(register.getUid(),am_grouping));
            }
        }else{
            //用户是合作社,根据用户id查询农机信息
            AmList.addAll(mapMapper.getGroupingAm(userRegister.getUid(),am_grouping));
        }
        //将用户查询到的农机信息添加到集合容器
        return AmList;
    }

    // 地图农机详细信息查询(根据农机编号查询)
    public MapDto getMapDto(String carId) {
        return mapMapper.getMapDto(carId);
    }
}
