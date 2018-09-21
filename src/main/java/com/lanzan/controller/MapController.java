package com.lanzan.controller;

import com.lanzan.entity.AgriculturalMachinery;
import com.lanzan.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MapController {

    @Autowired
    private MapService mapService;


    /**
     * 查询在线农机
     *
     * @return
     */
    @RequestMapping(value = "getOnLineAm")
    @ResponseBody
    public Map<String,Object> getOnLineAm(){
        List<AgriculturalMachinery> amNameAndId=mapService.getOnLineAm();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("data",amNameAndId);
        return map;
    }

    /**
     * 查询离线农机
     *
     * @return
     */
    @RequestMapping(value = "getOffLineAm")
    @ResponseBody
    public Map<String,Object> getOffLineAm(){
        List<AgriculturalMachinery> amNameAndId=mapService.getOffLineAm();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("data",amNameAndId);
        return map;
    }

    /**
     * 根据分组查询农机
     *
     * @return
     */
    @RequestMapping(value = "getGroupingAm")
    @ResponseBody
    public Map<String,Object> getGroupingAm(String am_grouping){
        List<AgriculturalMachinery> amNameAndId=mapService.getGroupingAm(am_grouping);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("data",amNameAndId);
        return map;
    }

}
