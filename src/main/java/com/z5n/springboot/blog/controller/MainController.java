package com.z5n.springboot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页控制器
 * @author zmx
 */
@Controller
public class MainController {


    // 访问主页，重定向到index
    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }

    // 主页
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    // 登录页（登陆成功）
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // 登陆失败，重定向到login
    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        model.addAttribute("errMessage", "登陆失败，用户名或密码错误");
        return "login";
    }

    // 用户注册
    @GetMapping("/register")
    public String register(){
        return "register";
    }

}
