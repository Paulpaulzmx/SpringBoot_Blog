package com.z5n.springboot.blog.repository.es;

import com.z5n.springboot.blog.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * EsBlog Repository 接口
 *
 * @author zmx
 */
@Repository
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {
    /**
     * 分页查询博客 EsBlog（去重）
     * @param title 博客标题
     * @param summary 博客摘要
     * @param content 博客内容
     * @return 查询结果
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining
    (String title, String summary, String content, Pageable pageable);

}
