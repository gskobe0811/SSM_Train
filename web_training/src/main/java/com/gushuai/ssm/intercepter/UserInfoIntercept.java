package com.gushuai.ssm.intercepter;

import com.gushuai.ssm.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by asus on 2017/7/3.
 * 个人中心拦截器
 */
public class UserInfoIntercept implements HandlerInterceptor{

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        boolean isLogin = true;
        String requestURI = request.getRequestURI();
        if(requestURI.indexOf("changeUserInfo") > 0){

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if(user != null && user.getUsername() != null){
                //登录成功
                isLogin = true;
            }else{
                //没有登录的用户,返回登录界面
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
                isLogin = false;
            }
        }else{
            isLogin = true;
        }
        return isLogin;

    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
