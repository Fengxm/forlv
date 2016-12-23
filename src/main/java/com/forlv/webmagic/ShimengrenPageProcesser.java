package com.forlv.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by xiaoming on 2016/12/22.
 */
public class ShimengrenPageProcesser implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    public void process(Page page) {
        List<String> links = page.getHtml().links().regex("http://www\\.shimengren\\.com/activity/operation/view-\\d+.jhtml").all();
        page.addTargetRequests(links);
        System.out.println(links);
//        page.putField("title",page.getHtml().xpath("//div[@class='carousel slide']/h4[@class='text-left']/text()").toString());
        page.putField("url",page.getUrl());
        page.putField("title",page.getHtml().xpath("/html/body/div[5]/div/div/div[1]/h1/text()").toString());
        if (page.getResultItems().get("title") == null || page.getResultItems().get("title").toString().trim().equals("")) {
            page.setSkip(true);
        }
        page.putField("activity_time",page.getHtml().xpath("/html/body/div[6]/div[1]/div[2]/div/ul[1]/li[3]/p/text()").toString());
        page.putField("address",page.getHtml().xpath("/html/body/div[6]/div[1]/div[2]/div/ul[1]/li[4]/p[1]/text()").toString());
        page.putField("join_num",page.getHtml().xpath("/html/body/div[6]/div[1]/div[2]/div/ul[1]/li[5]/p/text()").toString());
        page.putField("price",page.getHtml().xpath("/html/body/div[6]/div[1]/div[2]/div/ul[1]/li[2]/p/font/text()").toString());

    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new ShimengrenPageProcesser()).addUrl("http://www.shimengren.com/index.jhtml").addPipeline(new ConsolePipeline()).run();
    }
}
