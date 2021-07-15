package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * @author wyl
 * @create 2021-07-12 21:31
 */

@Controller
public class InfoController {

    @RequestMapping("/info")
    public String info(HttpServletRequest request,
                     HttpServletResponse response,
                     Model model
                     )throws ServletException, IOException {

        String method = request.getMethod();
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");

        model.addAttribute("method",method);
        model.addAttribute("email",email);
        model.addAttribute("pwd",pwd);

        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");


        Enumeration<String> reqHeadInfos = request.getHeaderNames();
        ArrayList names = new ArrayList();
        ArrayList values = new ArrayList();
        while (reqHeadInfos.hasMoreElements()) {
            String headName = (String) reqHeadInfos.nextElement();
            String headValue = headName+": "+request.getHeader(headName);
            values.add(headValue);
            }

        model.addAttribute("values",values);
        return "info";
    }
}
