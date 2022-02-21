package top.shijue.preservation.interceptor;/*
 * @Author: Dong
 * @DateTime: 2021/7/27 上午10:28
 * @Description: TODO 登录拦截器
 */

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录，未登录重定向登录页面
        if (null == request.getSession().getAttribute("user")) {
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}
