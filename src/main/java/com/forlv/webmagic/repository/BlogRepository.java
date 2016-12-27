package com.forlv.webmagic.repository;

import com.forlv.webmagic.model.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xiaoming on 2016/12/26.
 */

@Repository
public interface BlogRepository extends CrudRepository<Blog, Integer>{

}
