package com.lanzan.service.imp;

import com.lanzan.dao.RetrievePassMapper;
import com.lanzan.entity.User;
import com.lanzan.service.RetrievePassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "retrievePassService")
public class RetrievePassServiceImp implements RetrievePassService{

    @Autowired
    private RetrievePassMapper retrievePassMapper;

    // 判断用户名与手机号是否一致
    public int getNameAndPhoneAccordance(int uid, String uiphone) {
        return retrievePassMapper.getNameAndPhoneAccordance(uid,uiphone);
    }

    // 根据用户名修改密码
    public void updatePassInuname(User user) {
        retrievePassMapper.updatePassInuname(user);
    }
}
