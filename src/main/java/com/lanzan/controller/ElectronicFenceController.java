package com.lanzan.controller;

import com.lanzan.entity.ElectronicFence;
import com.lanzan.service.ElectronicFenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ElectronicFenceController {

    @Autowired
    private ElectronicFenceService electronicFenceService;

    /**
     * 添加电子围栏数据
     * @param
     *
     * @return
     */
    @RequestMapping(value = "addElectronicFence",method = RequestMethod.POST)
    @ResponseBody
    public String addElectronicFence(ElectronicFence electronicFence){
        if (null!=electronicFence && electronicFence.getEf_coordinate()!=null && electronicFence.getEf_coordinate()!=""){
            System.out.println("名名====="+electronicFence.getEf_name());
            electronicFenceService.addElectronicFence(electronicFence);
            return "true";
        }else {
            return null;
        }
    }

    /**
     * 查询电子围栏数据
     * @return
     */
    @RequestMapping(value = "listElectronicFence",method = RequestMethod.GET)
    @ResponseBody
    public List<ElectronicFence> listElectronicFence(){
       List<ElectronicFence> electronicFences = electronicFenceService.listElectronicFence();
       return electronicFences;
    }

}
