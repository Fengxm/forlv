package com.forlv.webmagic.crawler;

import com.forlv.webmagic.model.Shiyilvxing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class ShiyilvxingCrawler {

    @Resource
    private PageModelPipeline shiyilvxingPipeline;

    public void crawl(){
        OOSpider.create(Site.me().setTimeOut(1000),shiyilvxingPipeline,Shiyilvxing.class).addUrl("http://www.shiyilvxing.com/activity/index").thread(3).run();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext*.xml");
        final ShiyilvxingCrawler shiyilvxingCrawler = applicationContext.getBean(ShiyilvxingCrawler.class);
        shiyilvxingCrawler.crawl();
    }
}
