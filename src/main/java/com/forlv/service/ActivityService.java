package com.forlv.service;

import com.forlv.entity.Activity;
import com.forlv.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoming on 2016/12/27.
 */

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;


    public Activity findById(int id) {
        return activityRepository.findOne(id);
    }

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public List<Activity> findByTileLike(String wd) {
        return activityRepository.findByTitleLike(wd);
    }

}
