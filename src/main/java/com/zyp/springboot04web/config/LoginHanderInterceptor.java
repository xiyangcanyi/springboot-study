package com.zyp.springboot04web.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHanderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆成功之后，应该有用户session
        Object loginUser=request.getSession().getAttribute("loginUser");
        if (loginUser==null){
            request.setAttribute("msg","没用权限，请先登录");
            request.getRequestDispatcher("/html").forward(request,response);
            return false;
        }else {
        return false;
        }

    }
}
