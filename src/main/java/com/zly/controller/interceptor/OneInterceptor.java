package com.zly.controller.interceptor;

import com.zly.service.TokenService;
import com.zly.utils.JsonResult;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by zly11 on 2018/4/2.
 */
public class OneInterceptor implements HandlerInterceptor {
    @Resource
    private TokenService tokenService;
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("经过密码验证");
        if(httpServletRequest.getHeader("token")==null){
            return false;
        }
        String[] token = httpServletRequest.getHeader("token").split("&&");
        if (!tokenService.checkToken(token[1],token[0])) {
            System.out.println("未登录");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                JSONObject jsonObject = JSONObject.fromObject(JsonResult.noLogin());
                out = httpServletResponse.getWriter();
                out.write(jsonObject.toString());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            return true;
        }
        return false;
    }
}
