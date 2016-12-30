package com.forlv.controller;

import com.forlv.entity.Activity;
import com.forlv.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xiaoming on 2016/12/27.
 */

@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping(path = "/{id}", produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    String view(@PathVariable("id") int id) {
        return activityService.findById(id).getTitle();
    }

    @RequestMapping(path = "/search",produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Activity> find(@RequestParam("wd") String wd) {
        return activityService.findByTileLike(wd);
    }
}
