package com.lanzan.controller;

import com.lanzan.entity.User;
import com.lanzan.entity.UserInfo;
import com.lanzan.service.UserService;
import com.lanzan.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public String login(User user){
        System.out.println("进入");
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUname(), user.getUpass());
            /*try {
                subject.login(token);
                return "index";
            } catch (Exception ice) {
                ice.printStackTrace();
                System.out.println("账号/密码不匹配！");
                return "login";
            }*/
        try {
            //调取shiro框架的验证
            subject.login(token);
            return "login";
        }catch (UnknownAccountException e){
            System.out.println("用户不存在或错误");
            return "UnknownAccountException";
        }catch (IncorrectCredentialsException ex){
            System.out.println("用户不存在或错误");
            return "IncorrectCredentialsException";
        }catch (Exception e){
            System.out.println("内部错误，请重试");
            e.printStackTrace();
            return "Exception";
        }
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping(value = "outLogin")
    @ResponseBody
    public Map<String,Object> outLogin(HttpSession session){
        //通过session.invalidata()方法来注销当前的session
        Map<String,Object> map=new HashMap<String,Object>();
        session.invalidate();
        map.put("res","true");
        return map;
    }

    /**
     * 根据uid查询昵称与头像
     * @param uid
     *
     * @return
     */
    @RequestMapping(value = "getPhotoAndName", method = RequestMethod.GET)
    @ResponseBody
    public List<UserInfo> getPhotoAndName(int uid){
        List<UserInfo> userInfos=userService.getPhotoAndName(uid);
        return userInfos;
    }

}
