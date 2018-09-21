package com.lanzan.controller;

import com.lanzan.dto.UserDto;
import com.lanzan.service.MeunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MeunController {

    @Autowired
    private MeunService meunService;

    //用户拿取菜单
    //解决乱码问题 produces = "application/json;charset=utf-8"
    @RequestMapping(value = "getMeuns" , method = RequestMethod.GET)
    @ResponseBody
    public StringBuffer getCaiDan(HttpServletRequest request){
        UserDto userDto = (UserDto) request.getSession().getAttribute("userDto");
        return meunService.getMenus(userDto.getRid());
    }

}
