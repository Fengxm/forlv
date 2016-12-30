package com.forlv.webmagic.pipeline;

import com.forlv.webmagic.model.Shimengren;
import com.forlv.webmagic.repository.ShimengrenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by xiaoming on 2016/12/26.
 */

@Component("shimengrenPipeline")
public class ShimengrenPipeline implements PageModelPipeline<Shimengren> {

    @Autowired
    private ShimengrenRepository shimengrenRepository;

    @Override
    public void process(Shimengren shimengren, Task task) {
        shimengrenRepository.save(shimengren);
    }
}
