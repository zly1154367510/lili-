package com.zly.controller;

import com.zly.utils.DateUtils;
import com.zly.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by zly11 on 2018/6/17.
 */
@RestController
public class DateController {


    /**
     * 获取系统时间
     * 对比秒杀等需要时间校准的服务
     * @return
     */
    @RequestMapping("/getServiceTime")
    public JsonResult getServiceTime(){
        String format = "yyyy-MM-dd HH:mm";
        String date = DateUtils.formtSystemDate(format,new Date());
        return JsonResult.ok(date);
    }

}
