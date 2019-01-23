package com.syw.util;

import com.syw.demo1.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class UserUtil {
    private static final String userSession ="userSession";
    public static HttpSession getSession(){
        return ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
    }
    public static void setCurrentUser(User current){
        if(null==current){
            getSession().invalidate();//session失效
        }else {
            getSession().setAttribute(userSession,current);
        }
    }
    public static User getCurrentUser(){
        return (User) getSession().getAttribute(userSession);

    }
}
