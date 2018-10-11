package com.lanzan.service.imp;

import com.lanzan.dao.CarsRealTimeDtoMapper;
import com.lanzan.dao.UserRegisterMapper;
import com.lanzan.dto.CarsRealTimeDto;
import com.lanzan.dto.HistoryDto;
import com.lanzan.entity.UserRegister;
import com.lanzan.service.CarsRealTimeDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "carsRealTimeDtoService")
public class CarsRealTimeDtoServiceImp implements CarsRealTimeDtoService {

    @Autowired
    private CarsRealTimeDtoMapper carsRealTimeDtoMapper;
    @Autowired
    private UserRegisterMapper userRegisterMapper;

    // 任务历史轨迹列表
    public List<HistoryDto> listHistoryDto(int uid,String am_licensePlate, String am_SN, String beginTime, String endTime, int pageNum, int pageSize) {
        //返回的农机集合
        List<HistoryDto> HList = new ArrayList<HistoryDto>();
        //第一步 根据传入的uid拿到用户的信息
        UserRegister userRegister = userRegisterMapper.getUserRegisterByUid(uid);
        //判断用户的类型是农机站还是合作社
        if (userRegister.getUr_type() == 0){
            //用户是农机站
            //用户是农机站，查询他所属的合作社或农机站
            List<UserRegister> userRegisters = userRegisterMapper.getUserRegistersByUid(userRegister.getUid());
            for (UserRegister register : userRegisters) {
                //自己调用自己，拿到农机集合
                HList.addAll(listHistoryDto(register.getUid(),am_licensePlate,am_SN,beginTime,endTime,pageNum,pageSize));
            }
        }else{
            //用户是合作社,根据用户id查询农机信息
            List<HistoryDto> list = carsRealTimeDtoMapper.listHistoryDto(uid,am_licensePlate,am_SN,beginTime,endTime,pageNum,pageSize);
            HList.addAll(list);
        }
        //将用户查询到的农机信息添加到集合容器
        return HList;
        //return carsRealTimeDtoMapper.listHistoryDto(uid,am_licensePlate,am_SN,beginTime,endTime,pageNum,pageSize);
    }
    // 尾页
    public int endPageListHistoryDto(int uid, String am_licensePlate, String am_SN, String beginTime, String endTime) {
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
                count = count + endPageListHistoryDto(register.getUid(),am_licensePlate,am_SN,beginTime,endTime);
            }
        }else{
            //用户是合作社,根据用户id查询农机数量
            count = count + carsRealTimeDtoMapper.endPageListHistoryDto(userRegister.getUid(),am_licensePlate,am_SN,beginTime,endTime);
        }
        //将用户查询到的农机信息添加到集合容器
        return count;
        //return carsRealTimeDtoMapper.endPageListHistoryDto(uid, am_licensePlate,am_SN,beginTime,endTime);
    }

    // 历史轨迹
    public List<CarsRealTimeDto> listCarsRealTimeDto(String carNO,String startTime,String endTime) {
        if (carNO!=null && carNO!="" && startTime!=null && startTime!="" && endTime!=null && endTime!=""){
            return carsRealTimeDtoMapper.listCarsRealTimeDto(carNO,startTime,endTime);
        }else {
            return null;
        }
    }




}
