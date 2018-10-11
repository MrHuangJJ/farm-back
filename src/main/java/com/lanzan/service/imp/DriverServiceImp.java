package com.lanzan.service.imp;

import com.lanzan.dao.DriverMapper;
import com.lanzan.dao.UserRegisterMapper;
import com.lanzan.entity.Driver;
import com.lanzan.entity.UserRegister;
import com.lanzan.service.DriverService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "driverService")
public class DriverServiceImp implements DriverService {

    @Autowired
    private DriverMapper driverMapper;
    @Autowired
    private UserRegisterMapper userRegisterMapper;

    // 添加驾驶员
    public void addDriver(Driver driver) {
        driverMapper.addDriver(driver);
    }

    // 删除驾驶员
    public void deleteDriver(Driver driver) {
        driverMapper.deleteDriver(driver);
    }

    // 查询所以驾驶员信息
    public List<Driver> listDriver(int uid,String dGrouping, String dName, String dPhone, String dCard, int pageNum, int pageSize) {
        //返回的农机集合
        List<Driver> DList = new ArrayList<Driver>();
        //第一步 根据传入的uid拿到用户的信息
        UserRegister userRegister = userRegisterMapper.getUserRegisterByUid(uid);
        //判断用户的类型是农机站还是合作社
        if (userRegister.getUr_type() == 0){
            //用户是农机站
            //用户是农机站，查询他所属的合作社或农机站
            List<UserRegister> userRegisters = userRegisterMapper.getUserRegistersByUid(userRegister.getUid());
            for (UserRegister register : userRegisters) {
                //自己调用自己，拿到农机集合
                DList.addAll(listDriver(register.getUid(),dGrouping,dName,dPhone,dCard,pageNum,pageSize));
            }
        }else{
            //用户是合作社,根据用户id查询农机信息
            DList.addAll(driverMapper.listDriver(userRegister.getUid(),dGrouping,dName,dPhone,dCard,pageNum,pageSize));
        }
        //将用户查询到的农机信息添加到集合容器
        return DList;
    }
    //尾页
    public int endPageListDriver(int uid,String dGrouping, String dName, String dPhone, String dCard) {
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
                count = count + endPageListDriver(register.getUid(),dGrouping,dName,dPhone,dCard);
            }
        }else{
            //用户是合作社,根据用户id查询农机数量
            count = count + driverMapper.endPageListDriver(userRegister.getUid(),dGrouping,dName,dPhone,dCard);
        }
        //将用户查询到的农机信息添加到集合容器
        return count;
    }

    // 修改驾驶员信息
    public void updateDriver(Driver driver) {
        driverMapper.updateDriver(driver);
    }
}
