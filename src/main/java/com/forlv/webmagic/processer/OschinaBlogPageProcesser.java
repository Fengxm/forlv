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
public class OschinaBlogPageProcesser implements PageProcessor {

    private Site site = Site.me().setDomain("my.oschina.com");

    public void process(Page page) {
        List<String> links = page.getHtml().links().regex("https://my\\.oschina\\.net/u/921069/blog/\\d+").all();
        page.addTargetRequests(links);
        page.putField("title", page.getHtml().xpath("//div[@class='title']/text()").toString());
        if (page.getResultItems().get("title") == null || page.getResultItems().get("title").toString().trim().equals("")) {
            page.setSkip(true);
        }
        page.putField("abstract", page.getHtml().xpath("//div[@class='blog-abstract']/text()").toString());
        page.putField("tags", page.getHtml().xpath("//div[@class='tags']/span[@class='tag']/a/text()").all());

    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new OschinaBlogPageProcesser()).addUrl("https://my.oschina.net/u/921069/blog").addPipeline(new ConsolePipeline()).run();
    }
}
