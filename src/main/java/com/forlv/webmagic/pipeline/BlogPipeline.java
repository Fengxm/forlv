package com.forlv.webmagic.pipeline;

import com.forlv.webmagic.model.Blog;
import com.forlv.webmagic.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by xiaoming on 2016/12/26.
 */

@Component("blogPipeline")
public class BlogPipeline implements PageModelPipeline<Blog>{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void process(Blog blog, Task task) {
        blogRepository.save(blog);
    }
}
