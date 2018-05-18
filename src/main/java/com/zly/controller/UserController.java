package com.zly.controller;

import com.zly.pojo.TbShappingCar;
import com.zly.pojo.TbUser;
import com.zly.service.OrderService;
import com.zly.service.ShappingCarService;
import com.zly.service.UserService;
import com.zly.utils.FromToPojoUtil;
import com.zly.utils.JsonResult;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zly11 on 2018/5/13.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShappingCarService shappingCarService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/checkParam/{param}/{type}")
    public JsonResult checkParam(@PathVariable("param") String param,@PathVariable("type") Integer type){
        switch (userService.checkParam(param,type)){
            case 1:
                return JsonResult.paramError("用户名已存在");
            case 2:
                return JsonResult.paramError("手机号码已注册");
            case 3:
                return JsonResult.paramError("邮箱已注册");


        }
        return JsonResult.paramError("");
    }

    @RequestMapping(value = "/register")
    public JsonResult register(HttpServletRequest request){
        TbUser tbUser = (TbUser) FromToPojoUtil.FromToPojo(request, "com.zly.pojo.TbUser");
        if (userService.register(tbUser)!=0 ){;
            return JsonResult.ok("注册成功");
        }else{
            return JsonResult.errorMsg("注册失败");
        }
    }

    @RequestMapping(value = "/login")
    public JsonResult login(HttpServletRequest request){
        TbUser tbUser = (TbUser)FromToPojoUtil.FromToPojo(request,"com.zly.pojo.TbUser");
        String token = userService.login(tbUser);
        if (token==null){
           return JsonResult.errorMsg("账号或密码错误");
        }
        if (token.equals("被封禁")){
            return JsonResult.errorMsg("用户名被封禁，请联系后台人员");
        }
        return JsonResult.ok(token);
    }

    @RequestMapping("mi/token")
    public JsonResult test(HttpServletRequest request){
        //token[0]:token
        //token[1]:username
        String[] token = request.getHeader("token").split("&&");
        if (userService.isLogin(token[1],token[0])){
            return JsonResult.ok("用户已登录");
        }
        return JsonResult.noLogin();
    }

    @RequestMapping("mi/addShappingCar")
    public JsonResult  addShappingCar(HttpServletRequest request){
        String username = request.getParameter("username");
        Long iId = new Long(request.getParameter("iId"));
        int num = Integer.parseInt(request.getParameter("num"));
        if (shappingCarService.addShappingCar(username,iId,num)!=0){
            return JsonResult.ok("添加购物车成功");
        }
            return JsonResult.ok("添加购物车失败，请重试");

    }

    @RequestMapping("mi/getShappingCar")
    public JsonResult getShappingCar(HttpServletRequest request){

        String username = request.getParameter("username");
        List<TbShappingCar> list = shappingCarService.selectShappingCarByUId(username);
        if (list.size()!=0){
            return JsonResult.ok(list);
        }else{
            return JsonResult.ok();
        }
    }

    @RequestMapping("mi/changShappingCarNum")
    public JsonResult changShappingCarNum(HttpServletRequest request){
        Long id = new Long(request.getParameter("id"));
        Integer num = Integer.parseInt(request.getParameter("num"));
        int i = shappingCarService.changShappingCarNum(id,num);
        return JsonResult.ok(i);
    }

    @RequestMapping("mi/addOrder")
    public JsonResult addOrder(HttpServletRequest request){
        List<Long> list = new ArrayList<Long>() ;
        String name =  request.getParameter("name");
        String patment =  request.getParameter("patment");
        String payData =  request.getParameter("payData");
        String address =  request.getParameter("address");
        String username =  request.getParameter("username");
        JSONObject jsonObject = JSONObject.fromObject(payData);
        Iterator iterator = jsonObject.keys();
        while(iterator.hasNext()){
            list.add(new Long(iterator.next().toString()));
        }
        int i = orderService.addOrder(patment,new Date(),username,address,name,list);
        return JsonResult.ok(i);
    }

    @RequestMapping("mi/getOrder")
    public JsonResult getOrder(HttpServletRequest request){
        String username = request.getParameter("username");
        return JsonResult.ok(orderService.findAllByUid(username));
    }

}
