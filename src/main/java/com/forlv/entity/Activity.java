package com.forlv.entity;

import us.codecraft.webmagic.model.annotation.ExtractByUrl;

import javax.persistence.*;

/**
 * 旅行活动实体类
 * Created by xiaoming on 2016/12/27.
 */
@Entity
@Table(name = "ACTIVITY_INFO")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "URL")
    @ExtractByUrl
    private String url;
    @Column(name = "ACTIVITY_TIME")
    private String activityTime;
    @Column(name = "APPLICATION_PERIOD")
    private String applicationPeriod;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "JOIN_NUM_LIMIT")
    private String joinNumLimit;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    public String getApplicationPeriod() {
        return applicationPeriod;
    }

    public void setApplicationPeriod(String applicationPeriod) {
        this.applicationPeriod = applicationPeriod;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJoinNumLimit() {
        return joinNumLimit;
    }

    public void setJoinNumLimit(String joinNumLimit) {
        this.joinNumLimit = joinNumLimit;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", activityTime='" + activityTime + '\'' +
                ", applicationPeriod='" + applicationPeriod + '\'' +
                ", address='" + address + '\'' +
                ", joinNumLimit='" + joinNumLimit + '\'' +
                '}';
    }
}
