package com.lanzan.service.imp;

import com.lanzan.dao.AgriculturalMachineryMapper;
import com.lanzan.dao.UserRegisterMapper;
import com.lanzan.entity.AgriculturalMachinery;
import com.lanzan.entity.UserRegister;
import com.lanzan.service.AgriculturalMachineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "agriculturalMachineryService")
public class AgriculturalMachineryServiceImp implements AgriculturalMachineryService {

    @Autowired
    private AgriculturalMachineryMapper agriculturalMachineryMapper;
    @Autowired
    private UserRegisterMapper userRegisterMapper;

    // 添加农机
    public void addAgriculturalMachinery(AgriculturalMachinery agriculturalMachinery) {
        agriculturalMachineryMapper.addAgriculturalMachinery(agriculturalMachinery);
    }

    // 删除农机
    public void deleteAgriculturalMachinery(AgriculturalMachinery agriculturalMachinery) {
        agriculturalMachineryMapper.deleteAgriculturalMachinery(agriculturalMachinery);
    }

    // 查询农机
    public List<AgriculturalMachinery> listAgriculturalMachinery(int uid, String am_licensePlate, String am_grouping, String am_SN, int pageNum, int pageSize) {
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
                AmList.addAll(listAgriculturalMachinery(register.getUid(),am_licensePlate,am_grouping,am_SN,pageNum,pageSize));
            }
        }else{
            //用户是合作社,根据用户id查询农机信息
            AmList.addAll(agriculturalMachineryMapper.listAgriculturalMachinery(userRegister.getUid(),am_licensePlate,am_grouping,am_SN,pageNum,pageSize));
        }
        //将用户查询到的农机信息添加到集合容器
        return AmList;
    }
    // 尾页
    public int endPageListAgriculturalMachinery(int uid, String am_licensePlate, String am_grouping, String am_SN) {
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
                count = count + endPageListAgriculturalMachinery(register.getUid(),am_licensePlate,am_grouping,am_SN);
            }
        }else{
            //用户是合作社,根据用户id查询农机数量
            count = count + agriculturalMachineryMapper.endPageListAgriculturalMachinery(userRegister.getUid(),am_licensePlate,am_grouping,am_SN);
        }
        //将用户查询到的农机信息添加到集合容器
        return count;
    }

    // 修改农机
    public void updateAgriculturalMachinery(AgriculturalMachinery agriculturalMachinery) {
        agriculturalMachineryMapper.updateAgriculturalMachinery(agriculturalMachinery);
    }

    // 根据am_SM修改农机状态(在线)
    public void updateAmStateOn(String am_endOnTime,String am_state, String carId) {
        agriculturalMachineryMapper.updateAmStateOn(am_endOnTime,am_state,carId);
    }
    // 离线
    public void updateAmStateNo(String am_state, String carId) {
        agriculturalMachineryMapper.updateAmStateNo(am_state,carId);
    }


}
