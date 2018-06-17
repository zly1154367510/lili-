package com.zly.controller;

import com.zly.exception.RepeatKillException;
import com.zly.exception.SeckillCloseException;
import com.zly.exception.SeckillException;
import com.zly.pojo.TbSeckiil;
import com.zly.service.SeckillService;
import com.zly.utils.JsonResult;
import net.sf.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zly11 on 2018/6/16.
 */
@RestController
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    @RequestMapping("/getSameDays")
    public JsonResult getSameDays(@RequestParam("position")String position){
        List<TbSeckiil> list = seckillService.getAllSameDaySeckill();
        if(list.size() <= 0){
            return JsonResult.ok("今天没有秒杀活动");
        }
        if (position.equals("0")){
            return JsonResult.ok(list.get(0));
        }else {
            return JsonResult.ok(list);
        }
    }

    @RequestMapping("mi/submitOrder")
    public JsonResult submitOrder(
            @RequestParam("username")String username,
            @RequestParam("id")int id,
            @RequestParam("price")String price,
            @RequestParam("name")String name,
            @RequestParam("address")String addres
    ){
       try{
           seckillService.SubmitOrder(id,username,name,addres,price);
       }catch (SeckillCloseException e){
           return JsonResult.ok(e.getMessage());
       }catch (RepeatKillException e1){
           return JsonResult.ok(e1.getMessage());
       }catch (SeckillException e2){
           return JsonResult.ok(e2.getMessage());
       }
        return JsonResult.ok();
    }


}
