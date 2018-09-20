package com.lanzan.dao;

import com.lanzan.dto.MyDataDto;
import com.lanzan.entity.UserInfo;
import com.lanzan.entity.UserRegister;

import java.util.List;

/**
 *
 * 个人资料
 */
public interface MyDataDtoMapper {

    // 根据uid查询个人资料
    List<MyDataDto> listMyDataDto(int uid);

    // 根据uid修改个人资料
    void updateUserInfoDto(UserInfo userInfo);

    // 根据uid修改组织资料
    void updateUserRegisterDto(UserRegister userRegister);

}
