package com.lanzan.service.imp;

import com.lanzan.dao.ConditionSelectMapper;
import com.lanzan.service.ConditionSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "conditionSelectService")
public class ConditionSelectServiceImp implements ConditionSelectService{

    @Autowired
    private ConditionSelectMapper conditionSelectMapper;

    // 根据用户名查询uid
    public int unamegetuid(String uname) {
        return conditionSelectMapper.unamegetuid(uname);
    }
}
