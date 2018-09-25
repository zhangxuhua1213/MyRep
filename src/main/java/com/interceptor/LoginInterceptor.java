package com.interceptor;

import com.Utils.MD5;
import com.entity.Users;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        //System.out.println("this is preHandle of LoginInterceptor");
        HttpSession session=request.getSession();
        String login=(String)session.getAttribute("login");
        //System.out.println("login:"+login);
        String username=(String)session.getAttribute("username");
        if(login==null){
           // System.out.println("no user in LoginInterceptor!!!");
            request.getRequestDispatcher("login.html").forward(request, response);
            return false;
        }else {
            if(MD5.Checkpassword(username,login)){
                return true;  //返回true代表继续往下执行
            }else {
                System.out.println("用户信息错误！");
                request.getRequestDispatcher("login.html").forward(request, response);
                return false;
            }
        }

    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
