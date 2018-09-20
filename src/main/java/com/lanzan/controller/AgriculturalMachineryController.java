package com.lanzan.controller;

import com.lanzan.entity.AgriculturalMachinery;
import com.lanzan.service.AgriculturalMachineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AgriculturalMachineryController {

    @Autowired
    private AgriculturalMachineryService agriculturalMachineryService;

    /**
     * 添加农机
     * @param agriculturalMachinery
     *
     * @return
     */
    @RequestMapping(value = "addAgriculturalMachinery", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addAgriculturalMachinery(AgriculturalMachinery agriculturalMachinery){
        Map<String,Object> map=new HashMap<String,Object>();
        if (agriculturalMachinery.getAm_licensePlate()!=null && agriculturalMachinery.getAm_licensePlate()!=""
                && agriculturalMachinery.getAm_modelNumber()!=null && agriculturalMachinery.getAm_modelNumber()!=""
                && agriculturalMachinery.getAm_grouping()!=null && agriculturalMachinery.getAm_grouping()!=""
                && agriculturalMachinery.getAm_SN()!=null && agriculturalMachinery.getAm_SN()!=""){
            agriculturalMachineryService.addAgriculturalMachinery(agriculturalMachinery);
            map.put("res","true");
            return map;
        }else {
            map.put("res","false");
            return map;
        }
    }

    /**
     * 删除农机
     * @param agriculturalMachinery
     *
     * @return
     */
    @RequestMapping(value = "deleteAgriculturalMachinery", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteAgriculturalMachinery(AgriculturalMachinery agriculturalMachinery){
        Map<String,Object> map=new HashMap<String,Object>();
        if (agriculturalMachinery.getAm_licensePlate()!=null && agriculturalMachinery.getAm_licensePlate()!=""
                && agriculturalMachinery.getAm_modelNumber()!=null && agriculturalMachinery.getAm_modelNumber()!=""
                && agriculturalMachinery.getAm_grouping()!=null && agriculturalMachinery.getAm_grouping()!=""
                && agriculturalMachinery.getAm_SN()!=null && agriculturalMachinery.getAm_SN()!=""){
            agriculturalMachineryService.deleteAgriculturalMachinery(agriculturalMachinery);
            map.put("res","true");
            return map;
        }else {
            map.put("res","false");
            return map;
        }
    }

    /**
     * 查询农机
     *
     * @return
     */
    @RequestMapping(value = "listAgriculturalMachinery")
    @ResponseBody
    public Map<String,Object> listAgriculturalMachinery(String am_licensePlate,String am_grouping,String am_SN,int page, int limit){
        int sum=(page-1)*limit;
        int count=agriculturalMachineryService.endPageListAgriculturalMachinery(am_licensePlate,am_grouping,am_SN);
        List<AgriculturalMachinery> agriculturalMachineries = agriculturalMachineryService.listAgriculturalMachinery(am_licensePlate,am_grouping,am_SN,sum,limit);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data",agriculturalMachineries);
        return map;
    }

    /**
     * 修改农机
     * @param agriculturalMachinery
     *
     * @return
     */
    @RequestMapping(value = "updateAgriculturalMachinery", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateAgriculturalMachinery(AgriculturalMachinery agriculturalMachinery){
        Map<String,Object> map=new HashMap<String,Object>();
        if (agriculturalMachinery.getAm_licensePlate()!=null && agriculturalMachinery.getAm_licensePlate()!=""
                && agriculturalMachinery.getAm_modelNumber()!=null && agriculturalMachinery.getAm_modelNumber()!=""
                && agriculturalMachinery.getAm_grouping()!=null && agriculturalMachinery.getAm_grouping()!=""
                && agriculturalMachinery.getAm_SN()!=null && agriculturalMachinery.getAm_SN()!=""){
            agriculturalMachineryService.updateAgriculturalMachinery(agriculturalMachinery);
            map.put("res","true");
            return map;
        }else {
            map.put("res","false");
            return map;
        }
    }





}
