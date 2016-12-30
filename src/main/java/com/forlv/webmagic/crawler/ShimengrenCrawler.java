package com.forlv.webmagic.crawler;

import com.forlv.webmagic.model.Shimengren;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by xiaoming on 2016/12/26.
 */

@Component
public class ShimengrenCrawler {

    @Resource
    private PageModelPipeline shimengrenPipeline;

    public void crawl() {
        OOSpider.create(Site.me().setTimeOut(1000), shimengrenPipeline, Shimengren.class).addUrl("http://shimengren.com/activity/operation/search.jhtml?se_day_type=0").thread(3).run();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ShimengrenCrawler shimengrenCrawler = applicationContext.getBean(ShimengrenCrawler.class);
        shimengrenCrawler.crawl();
    }
}
