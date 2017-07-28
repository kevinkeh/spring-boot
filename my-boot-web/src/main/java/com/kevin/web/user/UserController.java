package com.kevin.web.user;

import com.kevin.user.UserService;
import com.kevin.model.db2.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


/**
 *
 * Created by zmxie on 2017/7/27.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到登录界面
     * @return login.tfl
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "/views/login";
    }

    @PostMapping(value = "/login")
    public String login(@Valid User user, BindingResult result, Model model) {
        try {
            Subject subject = SecurityUtils.getSubject();
            if (result.hasErrors()) {
                model.addAttribute("error", "参数错误！");
                return "/views/login";
            }
            // 身份验证
            subject.login(new UsernamePasswordToken(user.getLoginName(), user.getPassword()));
        } catch (AuthenticationException e) {
            // 身份验证失败
            model.addAttribute("error", "用户名或密码错误 ！");
            return "/views/login";
        }
        return "/views/index";
    }
}
