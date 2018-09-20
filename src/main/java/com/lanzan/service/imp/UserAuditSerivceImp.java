package com.lanzan.service.imp;

import com.lanzan.entity.RegInfo;
import com.lanzan.dao.UserAudit;
import com.lanzan.service.UserAuditService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userAuditService")
public class UserAuditSerivceImp implements UserAuditService {

    @Autowired
    private UserAudit userAudit;

    // 查询注册用户
    public List<RegInfo> listRegInfo(@Param(value = "pageNum") int pageNum, @Param(value = "pageSize") int pageSize) {
        return userAudit.listRegInfo(pageNum,pageSize);
    }
    // 尾页
    public int endPageListRegInfo() {
        return userAudit.endPageListRegInfo();
    }

    // 审核用户通过审核
    public void updateAuditState(RegInfo regInfo) {
        userAudit.updateAuditState(regInfo);
    }

    // 删除用户
    public void deleteAuditState(RegInfo regInfo) {
        userAudit.deleteAuditState(regInfo);
    }
}
