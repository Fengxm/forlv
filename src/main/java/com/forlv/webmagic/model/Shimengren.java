package com.forlv.webmagic.model;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import javax.persistence.*;
import java.util.Date;

/**
 * 拾梦人活动抽取模型
 * Created by xiaoming on 2016/12/26.
 */

@Entity
@Table(name = "ACTIVITY_INFO")
@TargetUrl("http://shimengren.com/activity/operation/view-\\d+.jhtml")
@HelpUrl("http://shimengren.com/activity/operation/search.jhtml\\?se_day_type=0&act_category=&act_topics=&pageNumber=\\d+")
public class Shimengren implements AfterExtractor {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "URL")
    @ExtractByUrl
    private String url;

    @Column(name = "TITLE")
    @ExtractBy("/html/body/div[5]/div/div/div[1]/h1/text()")
    private String title;

    @Column(name = "COST")
    @ExtractBy("/html/body/div[6]/div[1]/div[2]/div/ul[1]/li[2]/p/font/text()")
    private String cost;

    @Column(name = "TRAVEL_TIME")
    @ExtractBy("/html/body/div[6]/div[1]/div[2]/div/ul[1]/li[3]/p/text()")
    private String travel_time;

    @Column(name = "JOIN_NUM")
    @ExtractBy("/html/body/div[6]/div[1]/div[2]/div/ul[1]/li[5]/p/text()")
    private String join_num;

    @Column(name = "GATHER_ADDRESS")
    @ExtractBy("/html/body/div[6]/div[1]/div[2]/div/ul[1]/li[4]/p[1]/text()")
    private String gather_address;

    @Column(name = "CREATE_DATE")
    private Date createDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTravel_time() {
        return travel_time;
    }

    public void setTravel_time(String travel_time) {
        this.travel_time = travel_time;
    }

    public String getJoin_num() {
        return join_num;
    }

    public void setJoin_num(String join_num) {
        this.join_num = join_num;
    }

    public String getGather_address() {
        return gather_address;
    }

    public void setGather_address(String gather_address) {
        this.gather_address = gather_address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = new Date();
    }

    @Override
    public String toString() {
        return "Shimengren{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", cost='" + cost + '\'' +
                ", travel_time='" + travel_time + '\'' +
                ", join_num='" + join_num + '\'' +
                ", gather_address='" + gather_address + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    public void afterProcess(Page page) {

    }
}
