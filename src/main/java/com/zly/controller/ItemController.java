package com.zly.controller;

import com.zly.service.ItemParamGroupService;
import com.zly.service.ItemParamKeyService;
import com.zly.service.ItemService;
import com.zly.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

/**
 *
 * Created by zly11 on 2018/5/8.
 */

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemParamGroupService itemParamGroupServicel;

    @Autowired
    private ItemParamKeyService itemParamKeyService;


    @RequestMapping(value = "item/{cid}/{page}")
    private JsonResult getItemByCid(@PathVariable("cid") String cid,@PathVariable("page") int page){
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (pattern.matcher(cid).matches()){
            Long c = new Long(cid);
            return JsonResult.ok(itemService.findItemByCid(c,page));
        }else{

            return JsonResult.ok(itemService.findItemByKeyword(cid));
        }

    }

    @RequestMapping(value="itemDetalis/{id}")
    private JsonResult getItemDetalisByCid(@PathVariable("id") long id){
        return JsonResult.ok(itemService.findItemDetalisByCid(id));
    }

    @RequestMapping("itemParamGroup/{cid}")
    private JsonResult getItemDetalisParamGroup(@PathVariable("cid") long cid){
        return JsonResult.ok(itemParamGroupServicel.findItemParamGroupByItemCatId(cid));
    }

    @RequestMapping("itemParamKey/{groupId}")
    private JsonResult getItemDetalisParamKey(@PathVariable("groupId") long id){
        return JsonResult.ok(itemParamKeyService.findItemParamKeyByGroupId(id));
    }

    @RequestMapping("itemSimilar/{id}")
    private JsonResult getItemSimilar(@PathVariable("id") long id){
        return JsonResult.ok(itemService.findItemSimilar(id));
    }

//    @RequestMapping(value = "/item")
//    private JsonResult getItemByTitle(@RequestParam("keyword") String title,@PathVariable("page") int page){
//        return JsonResult.ok(itemService.findItemByKeyword(title));
//    }


}
