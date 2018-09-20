package com.lanzan.service.imp;

import com.lanzan.dao.HomeworkSeasonMapper;
import com.lanzan.entity.HomeworkSeason;
import com.lanzan.service.HomeworkSeasonService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "homeworkSeasonService")
public class HomeworkSeasonServiceImp implements HomeworkSeasonService {

    @Autowired
    private HomeworkSeasonMapper homeworkSeasonMapper;

    // 添加作业季
    public void addHomeworkSeason(HomeworkSeason homeworkSeason) {
        homeworkSeasonMapper.addHomeworkSeason(homeworkSeason);
    }

    // 删除作业季
    public void deleteHomeworkSeason(HomeworkSeason homeworkSeason) {
        homeworkSeasonMapper.deleteHomeworkSeason(homeworkSeason);
    }

    // 查询作业季
    public List<HomeworkSeason> listHomeworkSeason(
            @Param(value = "hs_grouping") String hs_grouping,
            @Param(value = "hs_type") String hs_type,
            @Param(value = "hs_beginTime") String hs_beginTime,
            @Param(value = "hs_endTime") String hs_endTime,
            @Param(value = "pageNum") int pageNum,
            @Param(value = "pageSize") int pageSize) {
        return homeworkSeasonMapper.listHomeworkSeason(hs_grouping,hs_type,hs_beginTime,hs_endTime,pageNum,pageSize);
    }
    // 尾页
    public int endPageListHomeworkSeason(@Param(value = "hs_grouping") String hs_grouping,
                                         @Param(value = "hs_type") String hs_type,
                                         @Param(value = "hs_beginTime") String hs_beginTime,
                                         @Param(value = "hs_endTime") String hs_endTime) {
        return homeworkSeasonMapper.endPageListHomeworkSeason(hs_grouping,hs_type,hs_beginTime,hs_endTime);
    }

    // 修改作业季
    public void updateHomeworkSeason(HomeworkSeason homeworkSeason) {
        homeworkSeasonMapper.updateHomeworkSeason(homeworkSeason);
    }
}
