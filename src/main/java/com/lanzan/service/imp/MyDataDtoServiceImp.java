package com.lanzan.service.imp;

import com.lanzan.dao.MyDataDtoMapper;
import com.lanzan.dto.MyDataDto;
import com.lanzan.entity.UserInfo;
import com.lanzan.entity.UserRegister;
import com.lanzan.service.MyDataDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "myDataDtoService")
public class MyDataDtoServiceImp implements MyDataDtoService{

    @Autowired
    private MyDataDtoMapper myDataDtoMapper;

    // 根据uid查询个人资料
    public List<MyDataDto> listMyDataDto(int uid) {
        return myDataDtoMapper.listMyDataDto(uid);
    }

    // 根据uid修改个人资料
    public void updateUserInfoDto(UserInfo userInfo) {
        myDataDtoMapper.updateUserInfoDto(userInfo);
    }

    // 根据uid修改组织资料
    public void updateUserRegisterDto(UserRegister userRegister) {
        myDataDtoMapper.updateUserRegisterDto(userRegister);
    }
}
