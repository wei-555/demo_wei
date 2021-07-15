package com.example.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author wyl
 * @create 2021-07-13 17:05
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("preHandle");
        if (handler instanceof HandlerMethod) {

            System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
            System.out.println(((HandlerMethod)handler).getMethod().getName());
            request.setAttribute("startTime", new Date().getTime());

            return true;
        } else if(handler instanceof ResourceHttpRequestHandler) {
            request.setAttribute("startTime", new Date().getTime());
            return true;
        }
        request.setAttribute("startTime", new Date().getTime());
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("time interceptor 耗时:"+ (new Date().getTime() - start));

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("afterCompletion");
        Long start = (Long) request.getAttribute("startTime");
        Long time = new Date().getTime() - start;
        System.out.println("time interceptor 耗时:"+ time);
        System.out.println("ex is "+ex);
        response.getWriter().append("耗时:"+time+"ms");


    }

}
