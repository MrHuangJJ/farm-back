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

}
