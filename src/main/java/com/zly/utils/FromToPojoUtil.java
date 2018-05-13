package com.zly.utils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by zly11 on 2018/5/13.
 */
public class FromToPojoUtil {


    public static Object FromToPojo(HttpServletRequest request,String s){
        try{
            Class<?> clazz = Class.forName(s);
            Object o = clazz.newInstance();
            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field:fields){
                if (request.getParameter(field.getName())==null){
                    continue;
                }
                field.setAccessible(true);
                String methodStr = "set"+field.getName().toUpperCase().substring(0, 1)+field.getName().substring(1);
                Method method = clazz.getMethod(methodStr,new Class[]{field.getType()});
                System.out.println(method);
                if(field.getType().getSimpleName().equals("String")){
                    method.invoke(o,request.getParameter(field.getName()) );
                }else if(field.getType().getSimpleName().equals("Integer")){
                    method.invoke(o, new Integer(request.getParameter(field.getName())));
                }
        }
            return o;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
