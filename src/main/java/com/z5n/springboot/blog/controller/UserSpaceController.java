package com.z5n.springboot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户个人主页控制器
 *
 * @author zmx
 */
@Controller
@RequestMapping("/u")
public class UserSpaceController {


    /**
     * 根据用户名访问用户个人主页，
     *
     * @param username 用户名
     */
    @GetMapping("/{username}")
    public String root(@PathVariable("username") String username) {
        System.out.println("username:" + username);
        return "/userspace/u";
    }

    /**
     * 用户个人博客页面
     *
     * @param username 用户名
     * @param category 类别
     * @param keyword  关键字
     * @param order    排序方式
     */
    @GetMapping("/{username}/blogs")
    public String listBlogsByOrder(@PathVariable("username") String username,
                                   @RequestParam(value = "order", required = false, defaultValue = "new") String order,
                                   @RequestParam(value = "category", required = false) Long category,
                                   @RequestParam(value = "keyword", required = false) String keyword) {
        if (category != null) {
            System.out.println("category:" + category);
            System.out.println("self link:" + "redirect:/u/" + username + "/blogs?category=" + category);
            return "/userspace/u";
        } else if (keyword != null && !keyword.isEmpty()) {
            System.out.println("keyword:" + keyword);
            System.out.println("self link:" + "redirect:/u/" + username + "/blogs?keyword=" + keyword);
            return "/userspace/u";
        }

        System.out.println("order" + order);
        System.out.println("self link:" + "redirect:/u/" + username + "/blogs?order=" + order);
        return "/userspace/u";
    }

    /**
     * 根据id查询Blog
     * @param id BlogId
     * @return
     */
    @GetMapping("/{username}/blogs/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id){
        System.out.println("blogId:" + id);
        return "/userspace/blog";
    }

    @GetMapping("/{username}/blog/edit")
    public String editBlog(){
        return "/username/blogedit";
    }

}
