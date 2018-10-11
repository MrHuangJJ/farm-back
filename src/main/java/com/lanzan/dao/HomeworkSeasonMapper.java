package com.lanzan.dao;

import com.lanzan.entity.HomeworkSeason;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 作业季管理
 */
public interface HomeworkSeasonMapper {

    // 添加作业季
    void addHomeworkSeason(HomeworkSeason homeworkSeason);

    // 删除作业季
    void deleteHomeworkSeason(HomeworkSeason homeworkSeason);

    // 查询作业季
    List<HomeworkSeason> listHomeworkSeason(
            @Param(value = "uid") int uid,
            @Param(value = "hs_grouping") String hs_grouping,
            @Param(value = "hs_type") String hs_type,
            @Param(value = "hs_beginTime") String hs_beginTime,
            @Param(value = "hs_endTime") String hs_endTime,
            @Param(value = "pageNum") int pageNum,
            @Param(value = "pageSize") int pageSize);
    // 尾页
    int endPageListHomeworkSeason(@Param(value = "uid") int uid,
                                  @Param(value = "hs_grouping") String hs_grouping,
                                  @Param(value = "hs_type") String hs_type,
                                  @Param(value = "hs_beginTime") String hs_beginTime,
                                  @Param(value = "hs_endTime") String hs_endTime);

    // 修改作业季
    void updateHomeworkSeason(HomeworkSeason homeworkSeason);

}
