package com.z5n.springboot.blog.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.z5n.springboot.blog.domain.User;
import com.z5n.springboot.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * User 控制器
 *
 * @since 1.0.0 2019年7月18日
 * @author zmx
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户
     */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList", userRepository.listUsers());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据id查询用户
     */
    @GetMapping("{id}")
    public ModelAndView list(@PathVariable("id") Long id, Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 创建用户
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 新建用户（赋予id值）
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 根据id删除用户
     */
    @GetMapping("/delete/{id}")
    public ModelAndView deleteById(@PathVariable("id") Long id, Model model){
        userRepository.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 根据id修改用户
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }

}
