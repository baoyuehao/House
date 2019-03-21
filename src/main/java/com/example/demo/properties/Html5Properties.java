package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by baoyu on 2018/9/19.
 * 网站信息配置类
 */
@Configuration
@ConfigurationProperties(prefix = "html5")
@Component
public class Html5Properties {

    /**
     * 网页主题
     */
    private String title;

    /**
     * 网页开发者
     */
    private String author;

    /**
     * 网页开发时间
     */
    private String time;

    /**
     * 网站公安编号
     */
    private String safeid;

    /**
     * 网站描述
     * @return
     */
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSafeid() {
        return safeid;
    }

    public void setSafeid(String safeid) {
        this.safeid = safeid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
