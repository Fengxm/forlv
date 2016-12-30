package com.forlv.webmagic.crawler;

import com.forlv.webmagic.model.Blog;
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
public class BlogCrawler {

    @Resource
    private PageModelPipeline blogPipeline;

    public void crawl() {
        OOSpider.create(Site.me().setTimeOut(1000), blogPipeline, Blog.class).addUrl("https://www.oschina.net/blog").thread(3).run();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext*.xml");
        final BlogCrawler blogCrawler = applicationContext.getBean(BlogCrawler.class);
        blogCrawler.crawl();
    }
}
