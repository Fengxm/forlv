package com.forlv.controller;

import com.forlv.entity.Activity;
import com.forlv.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by xiaoming on 2016/12/27.
 */

@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping(path = "/activity/{id}", produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    String view(@PathVariable("id") int id) {
        return activityService.findById(id).getTitle();
    }

    @RequestMapping("/activities")
    public ModelAndView list() {
        return new ModelAndView("activity/list");
    }

    @RequestMapping(path = "/activities/all", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public @ResponseBody List<Activity> all() {
        List<Activity> activityList = activityService.findAll();
        return activityList;
    }
}
