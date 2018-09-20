package com.lanzan.dao;

import com.lanzan.entity.RegInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 用户审核
 */
public interface UserAudit {

    // 查询注册用户
    List<RegInfo> listRegInfo(@Param(value = "pageNum") int pageNum, @Param(value = "pageSize") int pageSize);
    // 尾页
    int endPageListRegInfo();

    // 审核用户通过审核
    void updateAuditState(RegInfo regInfo);

    // 删除用户
    void deleteAuditState(RegInfo regInfo);



}
