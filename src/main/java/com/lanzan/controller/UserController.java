package com.lanzan.controller;

import com.lanzan.entity.User;
import com.lanzan.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token=new UsernamePasswordToken(user.getUname(), user.getUpass());
            token.setRememberMe(false);
            try {
                subject.login(token);
                return "index";
            } catch (IncorrectCredentialsException ice) {
                System.out.println("邮箱/密码不匹配！");
            } catch (LockedAccountException lae) {
                System.out.println("账户已被冻结！");
            }
        }
        return "login";
    }

}
