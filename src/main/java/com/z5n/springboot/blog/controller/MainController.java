package com.z5n.springboot.blog.controller;

import com.z5n.springboot.blog.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页控制器
 * @author zmx
 */
@Controller
public class MainController {


    /**
     * 访问主页，重定向到index
     */
    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }

    /**
     * 主页
     */
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 登录页面
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 登陆失败，重定向到login
     * @param model loginError用于标记登陆失败，errMessage失败信息.
     * @return 回到login，重新登陆
     */
    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        model.addAttribute("errMessage", "登陆失败，用户名或密码错误");
        return "login";
    }

    /**
     * 获取用户注册界面
     * <p>
     * 实际注册的{@code post}请求在{@link UserController}中的
     * 新建用户方法{@link UserController#saveOrUpdateUser(User)}
     * </p>
     * @see com.z5n.springboot.blog.controller.UserController#saveOrUpdateUser(User)
     */
    @GetMapping("/register")
    public String register(){
        return "register";
    }

}
