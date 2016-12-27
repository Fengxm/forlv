package com.forlv.webmagic.model;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import javax.persistence.*;

/**
 * Created by xiaoming on 2016/12/26.
 */
@Entity
@Table(name="SHIYILVXING_INFO")
@TargetUrl("http://www.shiyilvxing.com/activity/detail\\?id=\\d+")
@HelpUrl("http://www.shiyilvxing.com/activity\\?pageIndex=\\d+")
public class Shiyilvxing implements AfterExtractor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column(name="TITLE")
    @ExtractBy(value = "//div[@class='detail_time_attr_join_gray']/h4[@class='text-left']/text()")
    private String title;
    @Column(name="URL")
    @ExtractByUrl
    private String url;
    @Column(name="ACTIVITY_TIME")
    @ExtractBy(value="//div[@class='detail_Time']/div[@class='detail_Time_t']/p/text()")
    private String activityTime;
    @Column(name="APPLICATION_PERIOD")
    @ExtractBy(value="//div[@class='detail_Time']/div[@class='detail_Time_b']/p/text()")
    private String applicationPeriod;
    @Column(name="ADDRESS")
    @ExtractBy(value="//div[@class='detail_Attr']/div[@class='dt_address_item']/div[@class='detail_Attr_K']/p/text()")
    private String address;
    @Column(name="JOIN_NUM_LIMIT")
    @ExtractBy(value="//div[@class='detail_Joinnum']/div[@class='detail_Joinnum_b']/p/text()")
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
        return "Shiyilvxing{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", activityTime='" + activityTime + '\'' +
                ", applicationPeriod='" + applicationPeriod + '\'' +
                ", address='" + address + '\'' +
                ", joinNumLimit='" + joinNumLimit + '\'' +
                '}';
    }

    @Override
    public void afterProcess(Page page) {

    }
}
