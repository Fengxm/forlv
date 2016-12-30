package com.forlv.webmagic.processer;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * Created by xiaoming on 2016/12/23.
 */

@TargetUrl("https://my.oschina.net/u/\\d+/blog/\\d+")
@HelpUrl("https://my.oschina.net/u/\\d+/blog")
public class OschinaRepo {
    @ExtractBy(value = "//div[@class='title']/text()", notNull = true)
    private String title;
    @ExtractBy(value = "//div[@class='blog-abstract']/text()")
    private String abstracts;
    @ExtractBy(value = "//div[@class='tags']/span[@class='tag']/a/text()")
    private String tags;

    public static void main(String[] args) {
        OOSpider.create(Site.me().setTimeOut(1000), new ConsolePageModelPipeline(), OschinaRepo.class).addUrl("https://www.oschina.net/blog").run();
    }

}
