package com.zly.controller;

import com.zly.pojo.TbUser;
import com.zly.service.UserService;
import com.zly.utils.FromToPojoUtil;
import com.zly.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zly11 on 2018/5/13.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

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
        if (token!=null){
            return JsonResult.ok(token);
        }
        return JsonResult.errorMsg("账号或密码错误");
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


}
