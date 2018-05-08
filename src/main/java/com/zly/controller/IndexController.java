package com.zly.controller;


import com.zly.service.ItemCatService;
import com.zly.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zly11 on 2018/5/7.
 */
@RestController
public class IndexController {

    @Autowired
    private ItemCatService itemCatService;

    /**
     * 返回产品种类种类选择
     */
    @RequestMapping("/index")
    public JsonResult getSelList(){
        return JsonResult.ok(itemCatService.getItemCatParen());
    }

    /**
     *
     * 返回所传id item的子节点
     */
}
