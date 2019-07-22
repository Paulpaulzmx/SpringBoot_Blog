package com.z5n.springboot.blog.controller;

import com.z5n.springboot.blog.domain.es.EsBlog;
import com.z5n.springboot.blog.repository.es.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Blog控制器
 *
 * @author zmx
 */
@RestController
@RequestMapping("/blogs")
public class BlogController {

    /**
     * 根据顺序和关键词查询博客
     * @param order     顺序，new或old
     * @param keyword   关键词
     * @return          重定向到查询页面
     */
    @GetMapping
    public String listBlogs(@RequestParam(value = "order", required = false, defaultValue = "new") String order,
                            @RequestParam(value = "keyword", required = false) Long keyword) {
        System.out.println("order:" + order + "keyword" + keyword);
        return "redirect:/index?order=" + order + "&keyword=" + keyword;
    }

//    @Autowired
//    private EsBlogRepository esBlogRepository;
//
//
//    /**
//     * 根据 标题、摘要、内容 查找博客
//     *
//     * @param title     博客标题
//     * @param summary   博客摘要
//     * @param content   博客内容
//     * @param pageIndex 页码
//     * @param pageSize  页条目数
//     * @return 符合查询条件的结果List
//     */
//    @GetMapping
//    public List<EsBlog> list(
//            @RequestParam(value = "title") String title,
//            @RequestParam(value = "summary") String summary,
//            @RequestParam(value = "content") String content,
//            @RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex,
//            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
//
//        // 数据在test初始化
//        Pageable pageable = new PageRequest(pageIndex, pageSize);
//        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining
//                (title, summary, content, pageable);
//
//        System.out.println("---------start--------");
//        for (EsBlog esBlog : page.getContent()) {
//            System.out.println(esBlog.toString());
//        }
//        System.out.println("---------end--------");
//
//        return page.getContent();
//    }

}
