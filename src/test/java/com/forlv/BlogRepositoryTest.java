package com.forlv;

import com.forlv.webmagic.repository.BlogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiaoming on 2016/12/26.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml"})
public class BlogRepositoryTest {

    @Autowired
    private BlogRepository blogRepository;

    @Test
    public void testQuery(){
        blogRepository.findAll();
    }

}
