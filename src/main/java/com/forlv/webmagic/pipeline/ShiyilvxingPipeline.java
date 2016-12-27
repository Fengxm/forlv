package com.forlv.webmagic.pipeline;

import com.forlv.webmagic.model.Shiyilvxing;
import com.forlv.webmagic.repository.ShiyilvxingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by xiaoming on 2016/12/26.
 */

@Component("shiyilvxingPipeline")
public class ShiyilvxingPipeline implements PageModelPipeline<Shiyilvxing>{

    @Autowired
    private ShiyilvxingRepository shiyilvxingRepository;

    @Override
    public void process(Shiyilvxing shiyilvxing, Task task) {
        shiyilvxingRepository.save(shiyilvxing);
    }
}
