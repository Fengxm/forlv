package com.forlv.webmagic.model;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import javax.persistence.*;

/**
 * Created by xiaoming on 2016/12/26.
 */

@Entity
@Table(name="BLOG_INFO")
@TargetUrl("https://my.oschina.net/u/\\d+/blog/\\d+")
@HelpUrl("https://my.oschina.net/u/\\d+/blog")
public class Blog implements AfterExtractor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column(name="TITLE")
    @ExtractBy(value = "//div[@class='title']/text()",notNull = true)
    private String title;
    @Column(name="ABSTRACTS")
    @ExtractBy(value = "//div[@class='blog-abstract']/text()")
    private String abstracts;
    @Column(name="TAGS")
    @ExtractBy(value = "//div[@class='tags']/span[@class='tag']/a/text()")
    private String tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", abstracts='" + abstracts + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }

    @Override
    public void afterProcess(Page page) {

    }
}
