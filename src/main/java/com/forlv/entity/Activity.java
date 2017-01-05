package com.forlv.entity;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;

import javax.persistence.*;
import java.util.Date;

/**
 * 旅行活动实体类
 * Created by xiaoming on 2016/12/27.
 */
@Entity
@Table(name = "ACTIVITY_INFO")
public class Activity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "URL")
    private String url;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "COST")
    private String cost;

    @Column(name = "TRAVEL_TIME")
    private String travel_time;

    @Column(name = "JOIN_NUM")
    private String join_num;

    @Column(name = "GATHER_ADDRESS")
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
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Activity{" +
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
}
