package com.lanzan.service.imp;

import com.lanzan.dao.JudgeWhetherExistMapper;
import com.lanzan.service.JudgeWhetherExistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "judgeWhetherExistService")
public class JudgeWhetherExistServiceImp implements JudgeWhetherExistService {

    @Autowired
    private JudgeWhetherExistMapper judgeWhetherExistMapper;

    // 判断用户名是否存在
    public int getunameyesno(String uname) {
        return judgeWhetherExistMapper.getunameyesno(uname);
    }
    public int getAuditNameYesNo(String uname) {
        return judgeWhetherExistMapper.getAuditNameYesNo(uname);
    }

    // 判断手机号是否存在
    public int getPhoneYesNo(String phone) {
        return judgeWhetherExistMapper.getPhoneYesNo(phone);
    }
    public int getAuditPhoneYesNo(String phone) {
        return judgeWhetherExistMapper.getAuditPhoneYesNo(phone);
    }

    // 判断邮箱是否存在
    public int getEmailYesNo(String email) {
        return judgeWhetherExistMapper.getEmailYesNo(email);
    }
    public int getAuditEmailYesNo(String email) {
        return judgeWhetherExistMapper.getAuditEmailYesNo(email);
    }

    // 判断carID是否存在
    public int getCarIdYesNo(String carId) {
        return judgeWhetherExistMapper.getCarIdYesNo(carId);
    }

}
