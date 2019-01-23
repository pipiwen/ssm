package com.syw.demo1.interceptor;

import com.syw.util.UserUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(null== UserUtil.getCurrentUser()){
            System.out.println("-------if--interceptor:---:"+UserUtil.getCurrentUser());
            response.sendRedirect("/login.jsp");
            return false;//阻止往后放行
        }
        System.out.println("-------interceptor:---:"+UserUtil.getCurrentUser());
        return true;//放行给下一个拦截器
    }
}
