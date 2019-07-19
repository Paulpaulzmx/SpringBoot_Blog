package com.z5n.springboot.blog.controller;

import com.z5n.springboot.blog.domain.User;
import com.z5n.springboot.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        Iterable iterable = userRepository.findAll();
        List list = new ArrayList();
        iterable.forEach(single -> {list.add(single);});
        // Iterable 转为 List后再返回
        model.addAttribute("userList", list);
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据id查询用户
     */
    @GetMapping("{id}")
    public ModelAndView list(@PathVariable("id") Long id, Model model){
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 创建用户
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user", new User(null, null, null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 新建用户（赋予id值）
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        user = userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 根据id删除用户
     */
    @GetMapping("/delete/{id}")
    public ModelAndView deleteById(@PathVariable("id") Long id){
        userRepository.delete(id);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 根据id修改用户
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model){
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }

}
