package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wyl
 * @create 2021-07-14 0:59
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String hello(Model model){
        return "hello";
    }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("msg","hello");
        return "index";
    }
}
