package com.zly.controller;

import com.zly.service.ContentService;
import com.zly.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zly11 on 2018/5/12.
 */
@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/Content")
    public JsonResult getBigContent(@RequestParam("cId") Long cId){
        return JsonResult.ok(contentService.getBigContent(cId));
    }

}
