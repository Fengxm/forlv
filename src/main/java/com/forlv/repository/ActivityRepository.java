package com.forlv.repository;

import com.forlv.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiaoming on 2016/12/27.
 */

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Integer> {

    @Query("select a from Activity a where a.title like %:wd%")
    public List<Activity> findByTitleLike(@Param("wd") String wd);

}
