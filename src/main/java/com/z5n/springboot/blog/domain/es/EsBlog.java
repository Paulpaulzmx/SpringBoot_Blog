package com.z5n.springboot.blog.domain.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * Blog 文档实体类(Elastic Search)
 * @author zmx
 */
@Document(indexName = "blog", type="blog")
public class EsBlog implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String title;
    private String summary;
    private String content;

    /**
     * 无参构造器，JPA规范要求protected，防止直接使用
     */
    protected EsBlog() {
    }

    public EsBlog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EsBlog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
