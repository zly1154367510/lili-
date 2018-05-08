package com.zly.controller;

import com.zly.service.ItemService;
import com.zly.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by zly11 on 2018/5/8.
 */

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;


    @RequestMapping(value = "item/{cid}/{page}")
    private JsonResult getItemByCid(@PathVariable("cid") long cid,@PathVariable("page") int page){
        return JsonResult.ok(itemService.findItemByCid(cid,page));
    }


}
