package com.forlv.webmagic.processer;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by xiaoming on 2016/12/22.
 */
public class ShiyilvxingPageProcesser implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    public void process(Page page) {
        List<String> links = page.getHtml().links().regex("http://www\\.shiyilvxing\\.com/activity/detail\\?id=\\d+").all();
        page.addTargetRequests(links);
        page.putField("title", page.getHtml().xpath("//div[@class='carousel slide']/h4[@class='text-left']/text()").toString());
        page.putField("url", page.getUrl());
        page.putField("title", page.getHtml().$("div.detail_time_attr_join_gray").xpath("//h4[@class='text-left']/text()").toString());
//        if (page.getResultItems().get("title") == null || page.getResultItems().get("title").toString().trim().equals("")) {
//            page.setSkip(true);
//        }
        page.putField("activity_time", page.getHtml().xpath("//div[@class='detail_Time']//div[@class='detail_Time_t']/p/text()").toString());
        page.putField("application_period", page.getHtml().xpath("//div[@class='detail_Time']//div[@class='detail_Time_b']/p/text()").toString());
        page.putField("address", page.getHtml().xpath("/html/body/div[3]/div/div/div[4]/div[1]/div[1]/div/div[3]/div/div/p/text()").toString());
        page.putField("join_num_limit", page.getHtml().xpath("//div[@class='detail_Joinnum']//div[@class='detail_Joinnum_b']/p/text()").toString());

    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new ShiyilvxingPageProcesser()).addUrl("http://www.shiyilvxing.com/").addPipeline(new ConsolePipeline()).run();
    }
}
