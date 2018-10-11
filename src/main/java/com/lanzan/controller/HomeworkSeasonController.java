package com.lanzan.controller;

import com.lanzan.dto.UserDto;
import com.lanzan.entity.HomeworkSeason;
import com.lanzan.service.HomeworkSeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeworkSeasonController {

    @Autowired
    private HomeworkSeasonService homeworkSeasonService;

    /**
     * 添加作业季
     * @param homeworkSeason
     *
     * @return
     */
    @RequestMapping(value = "addHomeworkSeason", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addHomeworkSeason(HttpServletRequest request, HomeworkSeason homeworkSeason){
        Map<String,Object> map=new HashMap<String,Object>();
        if (homeworkSeason.getHs_name()!=null && homeworkSeason.getHs_name()!=""
                && homeworkSeason.getHs_type()!=null && homeworkSeason.getHs_type()!=""
                && homeworkSeason.getHs_grouping()!=null && homeworkSeason.getHs_grouping()!=""){
            UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
            //agriculturalMachinery.setUid(userDao.getUid());
            homeworkSeason.setUid(1);
            homeworkSeasonService.addHomeworkSeason(homeworkSeason);
            map.put("res","true");
            return map;
        }else {
            map.put("res","false");
            return map;
        }
    }

    /**
     * 删除作业季
     * @param homeworkSeason
     *
     * @return
     */
    @RequestMapping(value = "deleteHomeworkSeason", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object>  deleteHomeworkSeason(HomeworkSeason homeworkSeason){
        Map<String,Object> map=new HashMap<String,Object>();
        if (homeworkSeason.getHs_name()!=null && homeworkSeason.getHs_name()!=""
                && homeworkSeason.getHs_type()!=null && homeworkSeason.getHs_type()!=""
                && homeworkSeason.getHs_grouping()!=null && homeworkSeason.getHs_grouping()!=""){
            homeworkSeasonService.deleteHomeworkSeason(homeworkSeason);
            map.put("res","true");
            return map;
        }else {
            map.put("res","false");
            return map;
        }
    }

    /**
     * 查询作业季
     *
     * @return
     */
    @RequestMapping(value = "listHomeworkSeason")
    @ResponseBody
    public Map<String,Object> listHomeworkSeason(HttpServletRequest request,String years,String hs_grouping,String hs_type,String hs_beginTime,String hs_endTime,int page, int limit){
        if (years!=null && years!=""){
            hs_beginTime=years+"-01-01";
            hs_endTime=years+"-12-31";
        }
        UserDto userDao = (UserDto) request.getSession().getAttribute("userDto");
        //int uid = userDao.getUid();
        int uid = 1;
        int sum=(page-1)*limit;
        int count=homeworkSeasonService.endPageListHomeworkSeason(uid,hs_grouping,hs_type,hs_beginTime,hs_endTime);
        List<HomeworkSeason> homeworkSeasons = homeworkSeasonService.listHomeworkSeason(uid,hs_grouping,hs_type,hs_beginTime,hs_endTime,sum,limit);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data",homeworkSeasons);
        return map;
    }

    /**
     * 修改作业季
     * @param homeworkSeason
     *
     * @return
     */
    @RequestMapping(value = "updateHomeworkSeason", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object>  updateHomeworkSeason(HomeworkSeason homeworkSeason){
        Map<String,Object> map=new HashMap<String,Object>();
        if (homeworkSeason.getHs_name()!=null && homeworkSeason.getHs_name()!=""
                && homeworkSeason.getHs_type()!=null && homeworkSeason.getHs_type()!=""
                && homeworkSeason.getHs_grouping()!=null && homeworkSeason.getHs_grouping()!=""){
            homeworkSeasonService.updateHomeworkSeason(homeworkSeason);
            map.put("res","true");
            return map;
        }else {
            map.put("res","false");
            return map;
        }
    }

}
